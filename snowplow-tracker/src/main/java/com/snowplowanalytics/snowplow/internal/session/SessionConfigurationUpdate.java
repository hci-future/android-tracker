package com.snowplowanalytics.snowplow.internal.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.snowplowanalytics.snowplow.configuration.SessionConfiguration;
import com.snowplowanalytics.snowplow.util.TimeMeasure;

import java.util.concurrent.TimeUnit;

public class SessionConfigurationUpdate extends SessionConfiguration {

    @Nullable
    public SessionConfiguration sourceConfig;

    public boolean isPaused;

    public SessionConfigurationUpdate() {
        this(new TimeMeasure(30, TimeUnit.MINUTES), new TimeMeasure(30, TimeUnit.MINUTES));
    }

    public SessionConfigurationUpdate(@NonNull TimeMeasure foregroundTimeout, @NonNull TimeMeasure backgroundTimeout) {
        super(foregroundTimeout, backgroundTimeout);
    }

    // foregroundTimeout flag

    public boolean foregroundTimeoutUpdated;

    @NonNull
    public TimeMeasure getForegroundTimeout() {
        return (sourceConfig == null || foregroundTimeoutUpdated) ? super.foregroundTimeout : sourceConfig.foregroundTimeout;
    }

    // backgroundTimeout flag

    public boolean backgroundTimeoutUpdated;

    @NonNull
    public TimeMeasure getBackgroundTimeout() {
        return (sourceConfig == null || backgroundTimeoutUpdated) ? super.backgroundTimeout : sourceConfig.backgroundTimeout;
    }
}
