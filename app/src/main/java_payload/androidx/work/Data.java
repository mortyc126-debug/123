/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.work;

import android.util.Log;
import androidx.work.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Data {
    public static final Data EMPTY;
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG;
    Map<String, Object> mValues;

    static {
        TAG = Logger.tagWithPrefix("Data");
        EMPTY = new Builder().build();
    }

    Data() {
    }

    public Data(Data data) {
        this.mValues = new HashMap<String, Object>(data.mValues);
    }

    public Data(Map<String, ?> map2) {
        this.mValues = new HashMap(map2);
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] blArray) {
        Boolean[] booleanArray = new Boolean[blArray.length];
        for (int i = 0; i < blArray.length; ++i) {
            booleanArray[i] = blArray[i];
        }
        return booleanArray;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] byArray) {
        Byte[] byteArray = new Byte[byArray.length];
        for (int i = 0; i < byArray.length; ++i) {
            byteArray[i] = byArray[i];
        }
        return byteArray;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] dArray) {
        Double[] doubleArray = new Double[dArray.length];
        for (int i = 0; i < dArray.length; ++i) {
            doubleArray[i] = dArray[i];
        }
        return doubleArray;
    }

    public static Float[] convertPrimitiveFloatArray(float[] fArray) {
        Float[] floatArray = new Float[fArray.length];
        for (int i = 0; i < fArray.length; ++i) {
            floatArray[i] = Float.valueOf(fArray[i]);
        }
        return floatArray;
    }

    public static Integer[] convertPrimitiveIntArray(int[] nArray) {
        Integer[] integerArray = new Integer[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            integerArray[i] = nArray[i];
        }
        return integerArray;
    }

    public static Long[] convertPrimitiveLongArray(long[] lArray) {
        Long[] longArray = new Long[lArray.length];
        for (int i = 0; i < lArray.length; ++i) {
            longArray[i] = lArray[i];
        }
        return longArray;
    }

    public static byte[] convertToPrimitiveArray(Byte[] byteArray) {
        byte[] byArray = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; ++i) {
            byArray[i] = byteArray[i];
        }
        return byArray;
    }

    public static double[] convertToPrimitiveArray(Double[] doubleArray) {
        double[] dArray = new double[doubleArray.length];
        for (int i = 0; i < doubleArray.length; ++i) {
            dArray[i] = doubleArray[i];
        }
        return dArray;
    }

    public static float[] convertToPrimitiveArray(Float[] floatArray) {
        float[] fArray = new float[floatArray.length];
        for (int i = 0; i < floatArray.length; ++i) {
            fArray[i] = floatArray[i].floatValue();
        }
        return fArray;
    }

    public static int[] convertToPrimitiveArray(Integer[] integerArray) {
        int[] nArray = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; ++i) {
            nArray[i] = integerArray[i];
        }
        return nArray;
    }

    public static long[] convertToPrimitiveArray(Long[] longArray) {
        long[] lArray = new long[longArray.length];
        for (int i = 0; i < longArray.length; ++i) {
            lArray[i] = longArray[i];
        }
        return lArray;
    }

    public static boolean[] convertToPrimitiveArray(Boolean[] booleanArray) {
        boolean[] blArray = new boolean[booleanArray.length];
        for (int i = 0; i < booleanArray.length; ++i) {
            blArray[i] = booleanArray[i];
        }
        return blArray;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Data fromByteArray(byte[] var0) {
        block18: {
            block19: {
                if (((byte[])var0).length > 10240) throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                var8_7 = new HashMap<String, Object>();
                var9_8 = new ByteArrayInputStream((byte[])var0);
                var7_9 = null;
                var5_10 = null;
                var0 = null;
                var2_11 /* !! */  = var0;
                var4_14 = var7_9;
                var3_15 = var5_10;
                try {
                    var2_11 /* !! */  = var0;
                    var4_14 = var7_9;
                    var3_15 = var5_10;
                    var6_16 = new ObjectInputStream(var9_8);
                    var0 = var6_16;
                    var2_11 /* !! */  = var0;
                    var4_14 = var0;
                    var3_15 = var0;
                    for (var1_17 = var0.readInt(); var1_17 > 0; --var1_17) {
                        var2_11 /* !! */  = (byte[])var0;
                        var4_14 = var0;
                        var3_15 = var0;
                        var8_7.put(var0.readUTF(), var0.readObject());
                    }
                }
                catch (Throwable var0_3) {
                    break block18;
                }
                catch (ClassNotFoundException var0_4) {
                    var3_15 = var4_14;
                    break block19;
                }
                catch (IOException var0_5) {
                    // empty catch block
                    break block19;
                }
                try {
                    var0.close();
                }
                catch (IOException var0_1) {
                    Log.e((String)Data.TAG, (String)"Error in Data#fromByteArray: ", (Throwable)var0_1);
                }
                try {
                    var9_8.close();
                    return new Data(var8_7);
                }
                catch (IOException var0_2) {
                    Log.e((String)Data.TAG, (String)"Error in Data#fromByteArray: ", (Throwable)var0_2);
                    return new Data(var8_7);
                }
            }
            var2_11 /* !! */  = var3_15;
            {
                Log.e((String)Data.TAG, (String)"Error in Data#fromByteArray: ", (Throwable)var0);
                if (var3_15 == null) ** GOTO lbl-1000
            }
            try {
                var3_15.close();
            }
            catch (IOException var0_6) {
                Log.e((String)Data.TAG, (String)"Error in Data#fromByteArray: ", (Throwable)var0_6);
            }
lbl-1000:
            // 3 sources

            {
                var9_8.close();
                return new Data(var8_7);
            }
        }
        if (var2_11 /* !! */  != null) {
            try {
                var2_11 /* !! */ .close();
            }
            catch (IOException var2_12) {
                Log.e((String)Data.TAG, (String)"Error in Data#fromByteArray: ", (Throwable)var2_12);
            }
        }
        try {
            var9_8.close();
            throw var0_3;
        }
        catch (IOException var2_13) {
            Log.e((String)Data.TAG, (String)"Error in Data#fromByteArray: ", (Throwable)var2_13);
        }
        throw var0_3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] toByteArrayInternal(Data object) {
        Throwable throwable2222222;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        block19: {
            ObjectOutputStream objectOutputStream2;
            byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream3 = null;
            Object object2 = null;
            objectOutputStream = object2;
            ObjectOutputStream objectOutputStream4 = objectOutputStream3;
            objectOutputStream = object2;
            objectOutputStream4 = objectOutputStream3;
            objectOutputStream = objectOutputStream3 = (objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream));
            objectOutputStream4 = objectOutputStream3;
            objectOutputStream3.writeInt(((Data)object).size());
            objectOutputStream = objectOutputStream3;
            objectOutputStream4 = objectOutputStream3;
            object = ((Data)object).mValues.entrySet().iterator();
            while (true) {
                objectOutputStream = objectOutputStream3;
                objectOutputStream4 = objectOutputStream3;
                if (object.hasNext()) {
                    objectOutputStream = objectOutputStream3;
                    objectOutputStream4 = objectOutputStream3;
                    object2 = (Map.Entry)object.next();
                    objectOutputStream = objectOutputStream3;
                    objectOutputStream4 = objectOutputStream3;
                    objectOutputStream3.writeUTF((String)object2.getKey());
                    objectOutputStream = objectOutputStream3;
                    objectOutputStream4 = objectOutputStream3;
                    objectOutputStream3.writeObject(object2.getValue());
                    continue;
                }
                break;
            }
            {
                byte[] byArray;
                block20: {
                    catch (Throwable throwable2222222) {
                        break block19;
                    }
                    catch (IOException iOException) {}
                    objectOutputStream = objectOutputStream4;
                    {
                        Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
                        objectOutputStream = objectOutputStream4;
                        byArray = byteArrayOutputStream.toByteArray();
                        if (objectOutputStream4 == null) break block20;
                    }
                    try {
                        objectOutputStream4.close();
                    }
                    catch (IOException iOException) {
                        Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    return byArray;
                }
                catch (IOException iOException) {
                    Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
                }
                return byArray;
            }
            try {
                objectOutputStream3.close();
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
            }
            try {
                byteArrayOutputStream.close();
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
            }
            if (byteArrayOutputStream.size() > 10240) throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
            return byteArrayOutputStream.toByteArray();
        }
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            }
            catch (IOException iOException) {
                Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
            }
        }
        try {
            byteArrayOutputStream.close();
            throw throwable2222222;
        }
        catch (IOException iOException) {
            Log.e((String)TAG, (String)"Error in Data#toByteArray: ", (Throwable)iOException);
        }
        throw throwable2222222;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            object = (Data)object;
            Set<String> set = this.mValues.keySet();
            if (!((Object)set).equals(((Data)object).mValues.keySet())) {
                return false;
            }
            for (String string2 : set) {
                set = this.mValues.get(string2);
                Object object2 = ((Data)object).mValues.get(string2);
                boolean bl = set != null && object2 != null ? (set instanceof Object[] && object2 instanceof Object[] ? Arrays.deepEquals((Object[])set, (Object[])object2) : ((Object)set).equals(object2)) : set == object2;
                if (bl) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean getBoolean(String object, boolean bl) {
        if ((object = this.mValues.get(object)) instanceof Boolean) {
            return (Boolean)object;
        }
        return bl;
    }

    public boolean[] getBooleanArray(String object) {
        if ((object = this.mValues.get(object)) instanceof Boolean[]) {
            return Data.convertToPrimitiveArray((Boolean[])object);
        }
        return null;
    }

    public byte getByte(String object, byte by) {
        if ((object = this.mValues.get(object)) instanceof Byte) {
            return (Byte)object;
        }
        return by;
    }

    public byte[] getByteArray(String object) {
        if ((object = this.mValues.get(object)) instanceof Byte[]) {
            return Data.convertToPrimitiveArray((Byte[])object);
        }
        return null;
    }

    public double getDouble(String object, double d) {
        if ((object = this.mValues.get(object)) instanceof Double) {
            return (Double)object;
        }
        return d;
    }

    public double[] getDoubleArray(String object) {
        if ((object = this.mValues.get(object)) instanceof Double[]) {
            return Data.convertToPrimitiveArray((Double[])object);
        }
        return null;
    }

    public float getFloat(String object, float f) {
        if ((object = this.mValues.get(object)) instanceof Float) {
            return ((Float)object).floatValue();
        }
        return f;
    }

    public float[] getFloatArray(String object) {
        if ((object = this.mValues.get(object)) instanceof Float[]) {
            return Data.convertToPrimitiveArray((Float[])object);
        }
        return null;
    }

    public int getInt(String object, int n) {
        if ((object = this.mValues.get(object)) instanceof Integer) {
            return (Integer)object;
        }
        return n;
    }

    public int[] getIntArray(String object) {
        if ((object = this.mValues.get(object)) instanceof Integer[]) {
            return Data.convertToPrimitiveArray((Integer[])object);
        }
        return null;
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public long getLong(String object, long l) {
        if ((object = this.mValues.get(object)) instanceof Long) {
            return (Long)object;
        }
        return l;
    }

    public long[] getLongArray(String object) {
        if ((object = this.mValues.get(object)) instanceof Long[]) {
            return Data.convertToPrimitiveArray((Long[])object);
        }
        return null;
    }

    public String getString(String object) {
        if ((object = this.mValues.get(object)) instanceof String) {
            return (String)object;
        }
        return null;
    }

    public String[] getStringArray(String object) {
        if ((object = this.mValues.get(object)) instanceof String[]) {
            return (String[])object;
        }
        return null;
    }

    public <T> boolean hasKeyWithValueOfType(String object, Class<T> clazz) {
        boolean bl = (object = this.mValues.get(object)) != null && clazz.isAssignableFrom(object.getClass());
        return bl;
    }

    public int hashCode() {
        return ((Object)this.mValues).hashCode() * 31;
    }

    public int size() {
        return this.mValues.size();
    }

    public byte[] toByteArray() {
        return Data.toByteArrayInternal(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String string2 : this.mValues.keySet()) {
                stringBuilder.append(string2).append(" : ");
                Object object = this.mValues.get(string2);
                if (object instanceof Object[]) {
                    stringBuilder.append(Arrays.toString((Object[])object));
                } else {
                    stringBuilder.append(object);
                }
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static final class Builder {
        private Map<String, Object> mValues = new HashMap<String, Object>();

        public Data build() {
            Data data = new Data(this.mValues);
            Data.toByteArrayInternal(data);
            return data;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public Builder put(String string2, Object object) {
            if (object == null) {
                this.mValues.put(string2, null);
                return this;
            } else {
                Class<?> clazz = object.getClass();
                if (clazz != Boolean.class && clazz != Byte.class && clazz != Integer.class && clazz != Long.class && clazz != Float.class && clazz != Double.class && clazz != String.class && clazz != Boolean[].class && clazz != Byte[].class && clazz != Integer[].class && clazz != Long[].class && clazz != Float[].class && clazz != Double[].class && clazz != String[].class) {
                    if (clazz == boolean[].class) {
                        this.mValues.put(string2, Data.convertPrimitiveBooleanArray((boolean[])object));
                        return this;
                    } else if (clazz == byte[].class) {
                        this.mValues.put(string2, Data.convertPrimitiveByteArray((byte[])object));
                        return this;
                    } else if (clazz == int[].class) {
                        this.mValues.put(string2, Data.convertPrimitiveIntArray((int[])object));
                        return this;
                    } else if (clazz == long[].class) {
                        this.mValues.put(string2, Data.convertPrimitiveLongArray((long[])object));
                        return this;
                    } else if (clazz == float[].class) {
                        this.mValues.put(string2, Data.convertPrimitiveFloatArray((float[])object));
                        return this;
                    } else {
                        if (clazz != double[].class) throw new IllegalArgumentException("Key " + string2 + " has invalid type " + clazz);
                        this.mValues.put(string2, Data.convertPrimitiveDoubleArray((double[])object));
                    }
                    return this;
                } else {
                    this.mValues.put(string2, object);
                }
            }
            return this;
        }

        public Builder putAll(Data data) {
            this.putAll(data.mValues);
            return this;
        }

        public Builder putAll(Map<String, Object> object2) {
            for (Map.Entry entry : object2.entrySet()) {
                this.put((String)entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder putBoolean(String string2, boolean bl) {
            this.mValues.put(string2, bl);
            return this;
        }

        public Builder putBooleanArray(String string2, boolean[] blArray) {
            this.mValues.put(string2, Data.convertPrimitiveBooleanArray(blArray));
            return this;
        }

        public Builder putByte(String string2, byte by) {
            this.mValues.put(string2, by);
            return this;
        }

        public Builder putByteArray(String string2, byte[] byArray) {
            this.mValues.put(string2, Data.convertPrimitiveByteArray(byArray));
            return this;
        }

        public Builder putDouble(String string2, double d) {
            this.mValues.put(string2, d);
            return this;
        }

        public Builder putDoubleArray(String string2, double[] dArray) {
            this.mValues.put(string2, Data.convertPrimitiveDoubleArray(dArray));
            return this;
        }

        public Builder putFloat(String string2, float f) {
            this.mValues.put(string2, Float.valueOf(f));
            return this;
        }

        public Builder putFloatArray(String string2, float[] fArray) {
            this.mValues.put(string2, Data.convertPrimitiveFloatArray(fArray));
            return this;
        }

        public Builder putInt(String string2, int n) {
            this.mValues.put(string2, n);
            return this;
        }

        public Builder putIntArray(String string2, int[] nArray) {
            this.mValues.put(string2, Data.convertPrimitiveIntArray(nArray));
            return this;
        }

        public Builder putLong(String string2, long l) {
            this.mValues.put(string2, l);
            return this;
        }

        public Builder putLongArray(String string2, long[] lArray) {
            this.mValues.put(string2, Data.convertPrimitiveLongArray(lArray));
            return this;
        }

        public Builder putString(String string2, String string3) {
            this.mValues.put(string2, string3);
            return this;
        }

        public Builder putStringArray(String string2, String[] stringArray) {
            this.mValues.put(string2, stringArray);
            return this;
        }
    }
}

