package phils.example.flutter_platform_channel;

import android.os.Build;

import androidx.annotation.NonNull;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);

        BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();

        // se crea la instacion de methodChannel para escuchar el mensaje del cliente(flutter)
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "phils.examples/android_channel");
        methodChannel.setMethodCallHandler((MethodCall call, MethodChannel.Result result) -> {
            if(call.method.equals("getVersion")) {
                String version = getAndroidVersion();
                result.success(version);
            } else {
                result.notImplemented();
            }
        });
    }

    String getAndroidVersion() {
        int sdkVersion = Build.VERSION.SDK_INT;
        String release = Build.VERSION.RELEASE;
        return "Android version "+sdkVersion+" ("+release+")";
    }
}
