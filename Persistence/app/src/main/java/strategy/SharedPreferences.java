package strategy;

import android.os.Bundle;

public class SharedPreferences implements StrategyInterface {

    private Bundle bundle;

    @Override
    public Bundle read() {
        return bundle;
    }

    @Override
    public void write(String key, String value) {
        bundle.putString(key, value);
    }
}
