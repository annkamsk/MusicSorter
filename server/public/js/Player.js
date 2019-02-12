var audios = [];
var exists = new Map();

function makeSound(pitch, octave) {
    if (pitch.indexOf('#') > -1) {
        pitch = pitch.replace('#', '-');
    } else {
        pitch = '_' + pitch;
    }
    var filename = pitch.toLowerCase() + octave;
    // if (!audio) {
    audios.push(filename);
    // }
}

function waitAWhile() {
    setInterval(function () {
    }, 2000);
}

function swap(id1, id2) {
    var key1 = document.getElementById(id1);
    var key2 = document.getElementById(id2);
    setTimeout(function () {
        key1.id = id2;
        key2.id = id1;
    }, 1000);
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

