import 'dart:math';
import 'package:flutter/material.dart';
import 'package:music_player/theme.dart';
/**
 * @Author: Luke
 * @Date: 2019/3/20 16:46
 * @Sign: Cherish life and keep away from bugs!
 * @Project: music_player
 */

class ButtonControls extends StatelessWidget {
  const ButtonControls({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return new Container(
      width: double.infinity,
      child: Material(
        shadowColor: const Color(0x44000000),
        color: accentColor,
        child: Padding(
          padding: const EdgeInsets.only(top: 40.0, bottom: 50.0),
          child: new Column(
            children: <Widget>[
              new RichText(
                text: TextSpan(
                  text: '',
                  children: [
                    new TextSpan(
                      text: 'Song Title\n',
                      style: TextStyle(
                          color: Colors.white,
                          fontSize: 14.0,
                          fontWeight: FontWeight.bold,
                          letterSpacing: 4.0,
                          height: 1.5),
                    ),
                    new TextSpan(
                      text: 'Artist Name\n',
                      style: TextStyle(
                          color: Colors.white.withOpacity(0.75),
                          fontSize: 12.0,
                          fontWeight: FontWeight.bold,
                          letterSpacing: 3.0,
                          height: 1.5),
                    ),
                  ],
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(top: 40.0),
                child: new Row(
                  children: <Widget>[
                    new Expanded(child: new Container()),
                    new PreviousButton(),
                    new Expanded(child: new Container()),
                    new PlayPauseButton(),
                    new Expanded(child: new Container()),
                    new NextButton(),
                    new Expanded(child: new Container()),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class PlayPauseButton extends StatelessWidget {
  const PlayPauseButton({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return new RawMaterialButton(
      shape: new CircleBorder(),
      fillColor: Colors.white,
      splashColor: lightAccentColor,
      highlightColor: lightAccentColor.withOpacity(0.5),
      elevation: 10.0,
      highlightElevation: 5.0,
      onPressed: () {
        //todo
      },
      child: new Padding(
        padding: EdgeInsets.all(8.0),
        child: new Icon(
          Icons.play_arrow,
          color: darkAccentColor,
          size: 35.0,
        ),
      ),
    );
  }
}

class PreviousButton extends StatelessWidget {
  const PreviousButton({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return new IconButton(
        splashColor: lightAccentColor,
        highlightColor: Colors.transparent,
        icon: new Icon(
          Icons.skip_previous,
          color: Colors.white,
          size: 35.0,
        ),
        onPressed: () {
          // todo
        });
  }
}

class NextButton extends StatelessWidget {
  const NextButton({
    Key key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return new IconButton(
        splashColor: lightAccentColor,
        highlightColor: Colors.transparent,
        icon: new Icon(
          Icons.skip_next,
          color: Colors.white,
          size: 35.0,
        ),
        onPressed: () {
          // todo
        });
  }
}

class CircleClipper extends CustomClipper<Rect> {
  @override
  Rect getClip(Size size) {
    // TODO: implement getClip
    return new Rect.fromCircle(
      center: new Offset(size.width / 2, size.height / 2),
      radius: min(size.width, size.height) / 2,
    );
  }

  @override
  bool shouldReclip(CustomClipper<Rect> oldClipper) {
    // TODO: implement shouldReclip
    return null;
  }
}
