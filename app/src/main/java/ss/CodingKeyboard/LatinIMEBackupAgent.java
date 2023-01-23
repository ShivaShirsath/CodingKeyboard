package ss.CodingKeyboard;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;

/**
 * Backs up the Latin IME shared preferences.
 */
public class LatinIMEBackupAgent extends BackupAgentHelper {

    @Override
    public void onCreate() {
        addHelper("shared_pref", new SharedPreferencesBackupHelper(this,
                getPackageName() + "_preferences"));
    }
}
