function makeSound(pitch, octave) {
    if (pitch.indexOf('#') > -1) {
        pitch = pitch.replace('#', '-');
    } else {
        pitch = '_' + pitch;
    }
    var filename = pitch.toLowerCase() + octave;
    var horn = new Audio('versionedAssets/sounds/' + filename + '.mp3');
    return horn.play();
}

