import 'package:flutter/material.dart';

import 'package:flutter_platform_channel/platforms/android_channel.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: TextButton(
            onPressed: () {
              AndroidChannel androidChannel = AndroidChannel();
              androidChannel.getVersion();
            },
            child: const Text('get Version')),
      ),
    );
  }
}
