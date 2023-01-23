package ss.CodingKeyboard;

import android.app.backup.BackupManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class PrefScreenView extends PreferenceActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    private ListPreference mRenderModePreference;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(R.xml.prefs_view);
        SharedPreferences prefs = getPreferenceManager().getSharedPreferences();
        prefs.registerOnSharedPreferenceChangeListener(this);
        mRenderModePreference = (ListPreference) findPreference(LatinIME.PREF_RENDER_MODE);
    }

    @Override
    protected void onDestroy() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(
                this);
        super.onDestroy();
    }

    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
        (new BackupManager(this)).dataChanged();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        if (LatinKeyboardBaseView.sSetRenderMode == null) {
            mRenderModePreference.setEnabled(false);
            mRenderModePreference.setSummary(R.string.render_mode_unavailable);
        }
    }
}
