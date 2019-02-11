// var audios = new Map();

function makeSound(pitch, octave) {
    if (pitch.indexOf('#') > -1) {
        pitch = pitch.replace('#', '-');
    } else {
        pitch = '_' + pitch;
    }
    var filename = pitch.toLowerCase() + octave;
    // var audio = audios.get(filename);
    // if (!audio) {
    var audio = new Audio('versionedAssets/sounds/' + filename + '.mp3');
    // audios.set(filename, audio);
    // }
    return audio.play();
}

