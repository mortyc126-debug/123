/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Identity;
import com.jcraft.jsch.IdentityFile;
import com.jcraft.jsch.JSchException;
import java.util.Vector;

public interface IdentityRepository {
    public static final int NOTRUNNING = 1;
    public static final int RUNNING = 2;
    public static final int UNAVAILABLE = 0;

    public boolean add(byte[] var1);

    public Vector getIdentities();

    public String getName();

    public int getStatus();

    public boolean remove(byte[] var1);

    public void removeAll();

    public static class Wrapper
    implements IdentityRepository {
        private Vector cache = new Vector();
        private IdentityRepository ir;
        private boolean keep_in_cache = false;

        Wrapper(IdentityRepository identityRepository) {
            this(identityRepository, false);
        }

        Wrapper(IdentityRepository identityRepository, boolean bl) {
            this.ir = identityRepository;
            this.keep_in_cache = bl;
        }

        void add(Identity identity) {
            if (!this.keep_in_cache && !identity.isEncrypted() && identity instanceof IdentityFile) {
                try {
                    this.ir.add(((IdentityFile)identity).getKeyPair().forSSHAgent());
                }
                catch (JSchException jSchException) {}
            } else {
                this.cache.addElement(identity);
            }
        }

        @Override
        public boolean add(byte[] byArray) {
            return this.ir.add(byArray);
        }

        void check() {
            if (this.cache.size() > 0) {
                Object[] objectArray = this.cache.toArray();
                for (int i = 0; i < objectArray.length; ++i) {
                    Identity identity = (Identity)objectArray[i];
                    this.cache.removeElement(identity);
                    this.add(identity);
                }
            }
        }

        @Override
        public Vector getIdentities() {
            int n;
            Vector<Identity> vector = new Vector<Identity>();
            for (n = 0; n < this.cache.size(); ++n) {
                vector.add((Identity)this.cache.elementAt(n));
            }
            Vector vector2 = this.ir.getIdentities();
            for (n = 0; n < vector2.size(); ++n) {
                vector.add((Identity)vector2.elementAt(n));
            }
            return vector;
        }

        @Override
        public String getName() {
            return this.ir.getName();
        }

        @Override
        public int getStatus() {
            return this.ir.getStatus();
        }

        @Override
        public boolean remove(byte[] byArray) {
            return this.ir.remove(byArray);
        }

        @Override
        public void removeAll() {
            this.cache.removeAllElements();
            this.ir.removeAll();
        }
    }
}

