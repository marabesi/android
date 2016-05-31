package strategy;

import android.os.Bundle;

public interface StrategyInterface {

    public Bundle read();

    public void write(String key, String value);
}
