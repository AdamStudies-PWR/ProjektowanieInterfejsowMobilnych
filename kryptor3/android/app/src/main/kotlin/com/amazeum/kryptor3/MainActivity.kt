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
                    val version: String = converter.version;
                    result.success(version);
                }
                "encryptText" -> {
                    val text: String = call.argument<String>("message")!!;
                    val output: String = converter.encryption(text);
                    result.success(output);
                }
                "decryptText" -> {
                    val text: String = call.argument<String>("message")!!;
                    val output: String = converter.decryption(text);
                    result.success(output);
                }
                else -> result.notImplemented();
            }
        }
    }

    companion object {
        private val converter = Converter()
    }
}
