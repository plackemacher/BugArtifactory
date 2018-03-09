

-keep class com.core.Core {
    public *;
}

-keep class com.core.CoreEvents {
    public *;
}

-keep class com.core.CoreEvents$** {
    public *;
}

-keep public interface com.core.CoreEvents$** {
    *;
}