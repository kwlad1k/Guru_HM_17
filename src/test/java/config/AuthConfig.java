package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/auth.properties"
})

public interface AuthConfig extends Config {

    @Key("user.name")
    String userName();
    @Key("user.password")
    String password();
}
