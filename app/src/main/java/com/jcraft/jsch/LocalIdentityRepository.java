/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Identity;
import com.jcraft.jsch.IdentityFile;
import com.jcraft.jsch.IdentityRepository;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Util;
import java.util.Vector;

class LocalIdentityRepository
implements IdentityRepository {
    private static final String name = "Local Identity Repository";
    private Vector identities = new Vector();
    private JSch jsch;

    LocalIdentityRepository(JSch jSch) {
        this.jsch = jSch;
    }

    private void removeDupulicates() {
        int n;
        Vector<byte[]> vector = new Vector<byte[]>();
        int n2 = this.identities.size();
        if (n2 == 0) {
            return;
        }
        block0: for (n = 0; n < n2; ++n) {
            Identity identity = (Identity)this.identities.elementAt(n);
            byte[] byArray = identity.getPublicKeyBlob();
            if (byArray == null) continue;
            for (int i = n + 1; i < n2; ++i) {
                Identity identity2 = (Identity)this.identities.elementAt(i);
                byte[] byArray2 = identity2.getPublicKeyBlob();
                if (byArray2 == null || !Util.array_equals(byArray, byArray2) || identity.isEncrypted() != identity2.isEncrypted()) continue;
                vector.addElement(byArray);
                continue block0;
            }
        }
        for (n = 0; n < vector.size(); ++n) {
            this.remove((byte[])vector.elementAt(n));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void add(Identity identity) {
        synchronized (this) {
            if (!this.identities.contains(identity)) {
                byte[] byArray = identity.getPublicKeyBlob();
                if (byArray == null) {
                    this.identities.addElement(identity);
                    return;
                }
                for (int i = 0; i < this.identities.size(); ++i) {
                    byte[] byArray2 = ((Identity)this.identities.elementAt(i)).getPublicKeyBlob();
                    if (byArray2 == null || !Util.array_equals(byArray, byArray2)) continue;
                    if (!identity.isEncrypted() && ((Identity)this.identities.elementAt(i)).isEncrypted()) {
                        this.remove(byArray2);
                        continue;
                    }
                    return;
                }
                this.identities.addElement(identity);
            }
            return;
        }
    }

    @Override
    public boolean add(byte[] byArray) {
        synchronized (this) {
            try {
                this.add(IdentityFile.newInstance("from remote:", byArray, null, this.jsch));
                return true;
            }
            catch (JSchException jSchException) {
                return false;
            }
            finally {
            }
        }
    }

    @Override
    public Vector getIdentities() {
        synchronized (this) {
            this.removeDupulicates();
            Vector vector = new Vector();
            int n = 0;
            while (true) {
                if (n >= this.identities.size()) break;
                vector.addElement(this.identities.elementAt(n));
                ++n;
                continue;
                break;
            }
            return vector;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStatus() {
        return 2;
    }

    void remove(Identity identity) {
        synchronized (this) {
            if (this.identities.contains(identity)) {
                this.identities.removeElement(identity);
                identity.clear();
            } else {
                this.remove(identity.getPublicKeyBlob());
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean remove(byte[] byArray) {
        synchronized (this) {
            if (byArray == null) {
                return false;
            }
            int n = 0;
            while (n < this.identities.size()) {
                Identity identity = (Identity)this.identities.elementAt(n);
                Object object = identity;
                object = identity.getPublicKeyBlob();
                if (object != null && Util.array_equals(byArray, (byte[])object)) {
                    this.identities.removeElement(identity);
                    identity.clear();
                    return true;
                }
                ++n;
            }
            return false;
        }
    }

    @Override
    public void removeAll() {
        synchronized (this) {
            int n = 0;
            while (true) {
                Identity identity;
                if (n >= this.identities.size()) break;
                Identity identity2 = identity = (Identity)this.identities.elementAt(n);
                identity.clear();
                ++n;
                continue;
                break;
            }
            this.identities.removeAllElements();
            return;
        }
    }
}

