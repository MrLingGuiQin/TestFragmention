package com.example.ling.testfragmention;

public class MainActivity extends ProxyActivity {

    @Override
    public BaseDelegate setRootDelegate() {
        return new OneDelegate();
    }
}
