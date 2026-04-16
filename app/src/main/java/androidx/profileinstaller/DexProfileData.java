/*
 * Decompiled with CFR 0.152.
 */
package androidx.profileinstaller;

import java.util.TreeMap;

class DexProfileData {
    final String apkName;
    int classSetSize;
    int[] classes;
    final long dexChecksum;
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    DexProfileData(String string2, String string3, long l, long l2, int n, int n2, int n3, int[] nArray, TreeMap<Integer, Integer> treeMap) {
        this.apkName = string2;
        this.dexName = string3;
        this.dexChecksum = l;
        this.mTypeIdCount = l2;
        this.classSetSize = n;
        this.hotMethodRegionSize = n2;
        this.numMethodIds = n3;
        this.classes = nArray;
        this.methods = treeMap;
    }
}

