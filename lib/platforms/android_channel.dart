import 'package:flutter/services.dart';

class AndroidChannel {
  // se crea instancia de methodChannel
  // se agrega el identificar que debe ser usado en ios/android
  final MethodChannel _methodChannel =
      const MethodChannel('phils.examples/android_channel');

  // Definicion de metodo que sera llamado desde mi codigo nativo
  Future<void> getVersion() async {
    try {
      final version = await _methodChannel.invokeMethod('getVersion');
      print('version $version');
    } catch (e) {
      print('error al llamar al methodChannel $e');
    }
  }
}
