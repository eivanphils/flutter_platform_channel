import 'package:flutter/services.dart';

class AndroidChannel {
  final MethodChannel _methodChannel =
      const MethodChannel('phils.examples/android_channel');

  Future<void> getVersion() async {
    final version = await _methodChannel.invokeMethod('getVersion');
    print('version $version');
  }
}
