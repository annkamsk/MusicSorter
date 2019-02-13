var audios = [];
var exists = new Map();

function makeSound(pitch, octave) {
    if (pitch.indexOf('#') > -1) {
        pitch = pitch.replace('#', '-');
    } else {
        pitch = '_' + pitch;
    }
    var filename = pitch.toLowerCase() + octave;
    audios.push(filename);
}

function play(i) {
    if (i < audios.length) {
        var audio = exists.get(audios[i]);
        if (audio == null || audio === undefined) {
            audio = new Audio('versionedAssets/sounds/' + audios[i] + '.mp3');
            exists.set(audios[i], audio);
        }
        audio.onended = function () {
            play(i + 1);
        };
        audio.play();
    }
}

function clear() {
    audios = [];
}

