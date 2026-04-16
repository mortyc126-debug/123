/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Person
 *  android.app.Person$Builder
 *  android.graphics.drawable.Icon
 *  android.os.Bundle
 *  android.os.PersistableBundle
 */
package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    String mKey;
    CharSequence mName;
    String mUri;

    Person(Builder builder) {
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }

    public static Person fromAndroidPerson(android.app.Person person) {
        return Api28Impl.fromAndroidPerson(person);
    }

    public static Person fromBundle(Bundle bundle) {
        Object object = bundle.getBundle(ICON_KEY);
        Builder builder = new Builder().setName(bundle.getCharSequence(NAME_KEY));
        object = object != null ? IconCompat.createFromBundle(object) : null;
        return builder.setIcon((IconCompat)object).setUri(bundle.getString(URI_KEY)).setKey(bundle.getString(KEY_KEY)).setBot(bundle.getBoolean(IS_BOT_KEY)).setImportant(bundle.getBoolean(IS_IMPORTANT_KEY)).build();
    }

    public static Person fromPersistableBundle(PersistableBundle persistableBundle) {
        return Api22Impl.fromPersistableBundle(persistableBundle);
    }

    public boolean equals(Object object) {
        boolean bl = false;
        if (object == null) {
            return false;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        object = (Person)object;
        String string2 = this.getKey();
        String string3 = ((Person)object).getKey();
        if (string2 == null && string3 == null) {
            string3 = Objects.toString(this.getName());
            if (Objects.equals(string3, string2 = Objects.toString(((Person)object).getName())) && Objects.equals(this.getUri(), ((Person)object).getUri()) && Objects.equals(this.isBot(), ((Person)object).isBot()) && Objects.equals(this.isImportant(), ((Person)object).isImportant())) {
                bl = true;
            }
            return bl;
        }
        return Objects.equals(string2, string3);
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getKey() {
        return this.mKey;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }

    public int hashCode() {
        String string2 = this.getKey();
        if (string2 != null) {
            return string2.hashCode();
        }
        return Objects.hash(this.getName(), this.getUri(), this.isBot(), this.isImportant());
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    public String resolveToLegacyUri() {
        if (this.mUri != null) {
            return this.mUri;
        }
        if (this.mName != null) {
            return "name:" + this.mName;
        }
        return "";
    }

    public android.app.Person toAndroidPerson() {
        return Api28Impl.toAndroidPerson(this);
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(NAME_KEY, this.mName);
        Bundle bundle2 = this.mIcon != null ? this.mIcon.toBundle() : null;
        bundle.putBundle(ICON_KEY, bundle2);
        bundle.putString(URI_KEY, this.mUri);
        bundle.putString(KEY_KEY, this.mKey);
        bundle.putBoolean(IS_BOT_KEY, this.mIsBot);
        bundle.putBoolean(IS_IMPORTANT_KEY, this.mIsImportant);
        return bundle;
    }

    public PersistableBundle toPersistableBundle() {
        return Api22Impl.toPersistableBundle(this);
    }

    static class Api22Impl {
        private Api22Impl() {
        }

        static Person fromPersistableBundle(PersistableBundle persistableBundle) {
            return new Builder().setName(persistableBundle.getString(Person.NAME_KEY)).setUri(persistableBundle.getString(Person.URI_KEY)).setKey(persistableBundle.getString(Person.KEY_KEY)).setBot(persistableBundle.getBoolean(Person.IS_BOT_KEY)).setImportant(persistableBundle.getBoolean(Person.IS_IMPORTANT_KEY)).build();
        }

        static PersistableBundle toPersistableBundle(Person person) {
            PersistableBundle persistableBundle = new PersistableBundle();
            String string2 = person.mName != null ? ((Object)person.mName).toString() : null;
            persistableBundle.putString(Person.NAME_KEY, string2);
            persistableBundle.putString(Person.URI_KEY, person.mUri);
            persistableBundle.putString(Person.KEY_KEY, person.mKey);
            persistableBundle.putBoolean(Person.IS_BOT_KEY, person.mIsBot);
            persistableBundle.putBoolean(Person.IS_IMPORTANT_KEY, person.mIsImportant);
            return persistableBundle;
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Person fromAndroidPerson(android.app.Person person) {
            Builder builder = new Builder().setName(person.getName());
            IconCompat iconCompat = person.getIcon() != null ? IconCompat.createFromIcon(person.getIcon()) : null;
            return builder.setIcon(iconCompat).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }

        static android.app.Person toAndroidPerson(Person person) {
            Person.Builder builder = new Person.Builder().setName(person.getName());
            Icon icon = person.getIcon() != null ? person.getIcon().toIcon() : null;
            return builder.setIcon(icon).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }
    }

    public static class Builder {
        IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;
        String mKey;
        CharSequence mName;
        String mUri;

        public Builder() {
        }

        Builder(Person person) {
            this.mName = person.mName;
            this.mIcon = person.mIcon;
            this.mUri = person.mUri;
            this.mKey = person.mKey;
            this.mIsBot = person.mIsBot;
            this.mIsImportant = person.mIsImportant;
        }

        public Person build() {
            return new Person(this);
        }

        public Builder setBot(boolean bl) {
            this.mIsBot = bl;
            return this;
        }

        public Builder setIcon(IconCompat iconCompat) {
            this.mIcon = iconCompat;
            return this;
        }

        public Builder setImportant(boolean bl) {
            this.mIsImportant = bl;
            return this;
        }

        public Builder setKey(String string2) {
            this.mKey = string2;
            return this;
        }

        public Builder setName(CharSequence charSequence) {
            this.mName = charSequence;
            return this;
        }

        public Builder setUri(String string2) {
            this.mUri = string2;
            return this;
        }
    }
}

