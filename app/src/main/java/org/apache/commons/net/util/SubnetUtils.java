package org.apache.commons.net.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class SubnetUtils {
    private static final int NBITS = 32;
    private static final String PARSE_FAIL = "Could not parse [%s]";
    private final int address;
    private final int broadcast;
    private boolean inclusiveHostCount;
    private final int netmask;
    private final int network;
    private static final String IP_ADDRESS = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
    private static final Pattern ADDRESS_PATTERN = Pattern.compile(IP_ADDRESS);
    private static final String SLASH_FORMAT = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})/(\\d{1,2})";
    private static final Pattern CIDR_PATTERN = Pattern.compile(SLASH_FORMAT);

    public final class SubnetInfo {
        private static final long UNSIGNED_INT_MASK = 4294967295L;

        private SubnetInfo() {
        }

        public int asInteger(String address) {
            return SubnetUtils.toInteger(address);
        }

        private long broadcastLong() {
            return ((long) SubnetUtils.this.broadcast) & UNSIGNED_INT_MASK;
        }

        private String format(int[] octets) {
            int last = octets.length - 1;
            StringBuilder builder = new StringBuilder();
            int i = 0;
            while (true) {
                builder.append(octets[i]);
                if (i == last) {
                    return builder.toString();
                }
                builder.append('.');
                i++;
            }
        }

        public String getAddress() {
            return format(toArray(SubnetUtils.this.address));
        }

        @Deprecated
        public int getAddressCount() {
            long countLong = getAddressCountLong();
            if (countLong > 2147483647L) {
                throw new RuntimeException("Count is larger than an integer: " + countLong);
            }
            return (int) countLong;
        }

        public long getAddressCountLong() {
            long b = broadcastLong();
            long n = networkLong();
            long count = (b - n) + ((long) (SubnetUtils.this.isInclusiveHostCount() ? 1 : -1));
            if (count < 0) {
                return 0L;
            }
            return count;
        }

        public String[] getAllAddresses() {
            int ct2 = getAddressCount();
            String[] addresses = new String[ct2];
            if (ct2 == 0) {
                return addresses;
            }
            int add = low();
            int j2 = 0;
            while (add <= high()) {
                addresses[j2] = format(toArray(add));
                add++;
                j2++;
            }
            return addresses;
        }

        public String getBroadcastAddress() {
            return format(toArray(SubnetUtils.this.broadcast));
        }

        public String getCidrSignature() {
            return format(toArray(SubnetUtils.this.address)) + "/" + Integer.bitCount(SubnetUtils.this.netmask);
        }

        public String getHighAddress() {
            return format(toArray(high()));
        }

        public String getLowAddress() {
            return format(toArray(low()));
        }

        public String getNetmask() {
            return format(toArray(SubnetUtils.this.netmask));
        }

        public String getNetworkAddress() {
            return format(toArray(SubnetUtils.this.network));
        }

        public String getNextAddress() {
            return format(toArray(SubnetUtils.this.address + 1));
        }

        public String getPreviousAddress() {
            return format(toArray(SubnetUtils.this.address - 1));
        }

        private int high() {
            if (SubnetUtils.this.isInclusiveHostCount()) {
                return SubnetUtils.this.broadcast;
            }
            if (broadcastLong() - networkLong() > 1) {
                return SubnetUtils.this.broadcast - 1;
            }
            return 0;
        }

        public boolean isInRange(int address) {
            if (address == 0) {
                return false;
            }
            long addLong = ((long) address) & UNSIGNED_INT_MASK;
            long lowLong = ((long) low()) & UNSIGNED_INT_MASK;
            long highLong = UNSIGNED_INT_MASK & ((long) high());
            return addLong >= lowLong && addLong <= highLong;
        }

        public boolean isInRange(String address) {
            return isInRange(SubnetUtils.toInteger(address));
        }

        private int low() {
            if (SubnetUtils.this.isInclusiveHostCount()) {
                return SubnetUtils.this.network;
            }
            if (broadcastLong() - networkLong() > 1) {
                return SubnetUtils.this.network + 1;
            }
            return 0;
        }

        private long networkLong() {
            return ((long) SubnetUtils.this.network) & UNSIGNED_INT_MASK;
        }

        private int[] toArray(int val) {
            int[] ret = new int[4];
            for (int j2 = 3; j2 >= 0; j2--) {
                ret[j2] = ret[j2] | ((val >>> ((3 - j2) * 8)) & 255);
            }
            return ret;
        }

        public String toString() {
            StringBuilder buf = new StringBuilder();
            buf.append("CIDR Signature:\t[").append(getCidrSignature()).append("]\n").append("  Netmask: [").append(getNetmask()).append("]\n").append("  Network: [").append(getNetworkAddress()).append("]\n").append("  Broadcast: [").append(getBroadcastAddress()).append("]\n").append("  First address: [").append(getLowAddress()).append("]\n").append("  Last address: [").append(getHighAddress()).append("]\n").append("  Address Count: [").append(getAddressCountLong()).append("]\n");
            return buf.toString();
        }
    }

    private static int matchAddress(Matcher matcher) {
        int addr = 0;
        for (int i = 1; i <= 4; i++) {
            int n = rangeCheck(Integer.parseInt(matcher.group(i)), 0, 255);
            addr |= (n & 255) << ((4 - i) * 8);
        }
        return addr;
    }

    private static int rangeCheck(int value, int begin, int end) {
        if (value >= begin && value <= end) {
            return value;
        }
        throw new IllegalArgumentException("Value [" + value + "] not in range [" + begin + "," + end + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int toInteger(String address) {
        Matcher matcher = ADDRESS_PATTERN.matcher(address);
        if (matcher.matches()) {
            return matchAddress(matcher);
        }
        throw new IllegalArgumentException(String.format(PARSE_FAIL, address));
    }

    public SubnetUtils(String cidrNotation) {
        Matcher matcher = CIDR_PATTERN.matcher(cidrNotation);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format(PARSE_FAIL, cidrNotation));
        }
        this.address = matchAddress(matcher);
        int trailingZeroes = 32 - rangeCheck(Integer.parseInt(matcher.group(5)), 0, 32);
        this.netmask = (int) (4294967295 << trailingZeroes);
        this.network = this.address & this.netmask;
        this.broadcast = this.network | (~this.netmask);
    }

    public SubnetUtils(String address, String mask) {
        this.address = toInteger(address);
        this.netmask = toInteger(mask);
        if ((this.netmask & (-this.netmask)) - 1 != (~this.netmask)) {
            throw new IllegalArgumentException(String.format(PARSE_FAIL, mask));
        }
        this.network = this.address & this.netmask;
        this.broadcast = this.network | (~this.netmask);
    }

    public final SubnetInfo getInfo() {
        return new SubnetInfo();
    }

    public SubnetUtils getNext() {
        return new SubnetUtils(getInfo().getNextAddress(), getInfo().getNetmask());
    }

    public SubnetUtils getPrevious() {
        return new SubnetUtils(getInfo().getPreviousAddress(), getInfo().getNetmask());
    }

    public boolean isInclusiveHostCount() {
        return this.inclusiveHostCount;
    }

    public void setInclusiveHostCount(boolean inclusiveHostCount) {
        this.inclusiveHostCount = inclusiveHostCount;
    }
}
