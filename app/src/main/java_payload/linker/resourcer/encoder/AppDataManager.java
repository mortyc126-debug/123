/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppDataManager {
    private static final String KEY_APP_DATA = "appData";
    private static final String PREF_NAME = "AppDataPrefs";
    private final SharedPreferences sharedPreferences;

    public AppDataManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Map<String, List<String>> loadData() {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        ArrayList<String> arrayList = this.sharedPreferences.getString(KEY_APP_DATA, "{}");
        try {
            JSONObject jSONObject = new JSONObject((String)((Object)arrayList));
            Iterator iterator2 = jSONObject.keys();
            while (iterator2.hasNext()) {
                String string2 = (String)iterator2.next();
                JSONArray jSONArray = jSONObject.getJSONArray(string2);
                arrayList = new ArrayList<String>();
                for (int i = 0; i < jSONArray.length(); ++i) {
                    arrayList.add(jSONArray.getString(i));
                }
                hashMap.put(string2, arrayList);
            }
            return hashMap;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return hashMap;
    }

    private void saveData(Map<String, List<String>> object) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry entry : object.entrySet()) {
                JSONArray jSONArray = new JSONArray((Collection)entry.getValue());
                jSONObject.put((String)entry.getKey(), (Object)jSONArray);
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        this.sharedPreferences.edit().putString(KEY_APP_DATA, jSONObject.toString()).apply();
    }

    public void addData(String string2, String string3) {
        Map<String, List<String>> map2 = this.loadData();
        map2.putIfAbsent(string2, new ArrayList());
        map2.get(string2).add(string3);
        this.saveData(map2);
    }

    public void clearData(String string2) {
        Map<String, List<String>> map2 = this.loadData();
        map2.remove(string2);
        this.saveData(map2);
    }

    public List<String> getData(String string2) {
        return this.loadData().getOrDefault(string2, new ArrayList());
    }

    public boolean removeData(String list, String string2) {
        Map<String, List<String>> map2 = this.loadData();
        list = map2.get(list);
        if (list != null && list.remove(string2)) {
            this.saveData(map2);
            return true;
        }
        return false;
    }
}

