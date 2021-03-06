package com.mapzen.support;

import com.mapzen.activity.BaseActivity;
import com.mapzen.location.LocationHelper;

import org.oscim.map.Map;
import org.oscim.map.TestMap;

import android.app.ActionBar;
import android.database.sqlite.SQLiteDatabase;

public class TestBaseActivity extends BaseActivity {
    private ActionBar actionBar = new TestActionBar();
    private boolean backPressed = false;
    private boolean optionsMenuInvalidated = false;
    private Map map = new TestMap();

    @Override
    public ActionBar getActionBar() {
        return actionBar;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backPressed = true;
    }

    public boolean isBackPressed() {
        return backPressed;
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        super.supportInvalidateOptionsMenu();
        optionsMenuInvalidated = true;
    }

    public boolean isOptionsMenuInvalidated() {
        return optionsMenuInvalidated;
    }

    @Override
    public Map getMap() {
        return map;
    }

    public SQLiteDatabase getReadableDb() {
        return dbHelper.getReadableDatabase();
    }

    public LocationHelper.ConnectionCallbacks getConnectionCallback() {
        return connectionCallback;
    }
}
