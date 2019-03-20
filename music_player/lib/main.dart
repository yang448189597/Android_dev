import 'dart:math';

import 'package:flutter/material.dart';
import 'package:music_player/bottomControls.dart';
import 'package:music_player/songs.dart';
import 'package:music_player/theme.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: new MaterialApp(
        //导航栏 名字
        title: "Night Sky",
        debugShowCheckedModeBanner: false,
        //App 样式
        theme: new ThemeData(
          primaryColor: Colors.lightBlue,
          primarySwatch: Colors.lightBlue,
        ),
        home: new MyHomePage(),
      ),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  MyHomePageState createState() => new MyHomePageState();
}

class MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0.0,
        leading: IconButton(
            icon: Icon(Icons.arrow_back_ios),
            color: const Color(0xFFDDDDDD),
            onPressed: () {}),
        title: new Text(''),
        actions: <Widget>[
          IconButton(
              icon: Icon(Icons.menu),
              color: const Color(0xFFDDDDDD),
              onPressed: () {}),
        ],
      ),

      body: Column(
        children: <Widget>[
          // seek bar
          new Expanded(
            child: new Center(
              child: new Container(
                width: 125.0,
                height: 125.0,
                child: new ClipOval(
                  clipper: new CircleClipper(),
                  child: new Image.network(
                    demoPlaylist.songs[0].albumArtUrl,
                    fit: BoxFit.cover,
                  ),
                ),
              ),
            ),
          ),

          // visualizer
          new Container(
            width: double.infinity,
            height: 125.0,
          ),

          // song title, artist name ,and controls
          new ButtonControls(),
        ],
      ),
    );
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  void dispose() {
    // TODO: implement dispose
    super.dispose();
  }

  @override
  void didUpdateWidget(MyHomePage oldWidget) {
    // TODO: implement didUpdateWidget
    super.didUpdateWidget(oldWidget);
  }

  @override
  void didChangeDependencies() {
    // TODO: implement didChangeDependencies
    super.didChangeDependencies();
  }
}

