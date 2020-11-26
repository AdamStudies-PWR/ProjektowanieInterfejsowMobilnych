package com.amazeum.kryptor3

import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {
    private val CHANNEL = "com.amazeum.kryptor3/native";

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
            // Note: this method is invoked on the main thread.
            call, result ->
            when (call.method) {
                "getEngineVersion" -> {
                    val batteryLevel = converter.version;
                    result.success(batteryLevel);
                }
                else -> result.notImplemented();
            }
        }
    }

    companion object {
        private val converter = Converter()
    }
}
