class Settings{
    constructor(){
        this.textSize = 16;

        this.firstPage();
    }

    firstPage() {
        document.getElementById('first').innerHTML = "Text Settings";
        document.getElementById('second').innerHTML = "Graphic settings";
        document.getElementById('third').innerHTML = "Game Settings";
        document.getElementById('fourth').innerHTML = "Audio Settings";
        document.getElementById('last').innerHTML = "Back";
        document.getElementById('info').innerHTML = "";

        this.removeEventListeners();

        document.getElementById('first').addEventListener('click', () => {
            this.textSettings();
        });
    }

    textSettings() {
        document.getElementById('firstRow').style.opacity = '1';
        document.getElementById('first').innerHTML = "Text Color";
        document.getElementById('second').innerHTML = "Text Font";
        document.getElementById('third').innerHTML = "Text Size";
        document.getElementById('fourth').innerHTML = "For colorblind";
        document.getElementById('last').innerHTML = "Back";
        document.getElementById('info').innerHTML = "";

        this.removeEventListeners();

        document.getElementById('first').addEventListener('click', () => {
            this.textColorSettings();
        });
        document.getElementById('third').addEventListener('click', () => {
            this.textSizeSettings();
        });
        document.getElementById('last').addEventListener('click', () => {
            this.firstPage();
        });

        //document.getElementById('firstrow').style.display = 'flex';
    }

    textSizeSettings() {
        document.getElementById('firstRow').style.opacity = '0';

        document.getElementById('third').innerHTML = "Size +";
        document.getElementById('fourth').innerHTML = "Size -";
        document.getElementById('last').innerHTML = "Back";
        document.getElementById('info').innerHTML = "Text size";

        this.removeEventListeners();

        document.getElementById('third').addEventListener('click', () => {
            this.textSize += 1;
            document.body.style.fontSize = this.textSize + "px";
            document.getElementById('log').innerHTML += `<br> New text size: ${this.textSize} pixels <button onclick="settings.applyTextSize(${this.textSize})">Use this version</button>`;
        });
        document.getElementById('fourth').addEventListener('click', () => {
            this.textSize -= 1;
            document.body.style.fontSize = this.textSize + "px";
            document.getElementById('log').innerHTML += `<br> New text size: ${this.textSize} pixels <button onclick="settings.applyTextSize(${this.textSize})">Use this version</button>`;
        });
        

        document.getElementById('last').addEventListener('click', () => {
            this.textSettings();
        });
        
    }

    textColorSettings() {
        document.getElementById('first').innerHTML = "White";
        document.getElementById('second').innerHTML = "Black";
        document.getElementById('third').innerHTML = "Red";
        document.getElementById('fourth').innerHTML = "Yellow";
        document.getElementById('last').innerHTML = "Back";
        document.getElementById('info').innerHTML = "";

        this.removeEventListeners();

        document.getElementById('first').addEventListener('click', () => {
            this.applyTextColor("White")
            document.getElementById('log').innerHTML += `<br> New text color: White <button onclick='settings.applyTextColor("White")'>Use this version</button>`;
        });
        document.getElementById('second').addEventListener('click', () => {
            this.applyTextColor("Black")
            document.getElementById('log').innerHTML += `<br> New text color: Black <button onclick='settings.applyTextColor("Black")'>Use this version</button>`;
        });
        document.getElementById('third').addEventListener('click', () => {
            this.applyTextColor("Red")
            document.getElementById('log').innerHTML += `<br> New text color: Red <button onclick='settings.applyTextColor("Red")'>Use this version</button>`;
        });
        
        document.getElementById('fourth').addEventListener('click', () => {
            this.applyTextColor("Yellow")
            document.getElementById('log').innerHTML += `<br> New text color: Yellow <button onclick='settings.applyTextColor("Yellow")'>Use this version</button>`;
        });
        

        document.getElementById('last').addEventListener('click', () => {
            this.textSettings();
        });
        
    }

    removeEventListeners() {
        const elements = ['first', 'second', 'third', 'fourth', 'last'];
        elements.forEach(id => {
            const el = document.getElementById(id);
            const newEl = el.cloneNode(true);
            el.parentNode.replaceChild(newEl, el);
        });
    }

    applyTextSize(size) {
        document.body.style.fontSize = size + "px";
        this.textSize = size;
    }

    applyTextColor(color) {
        document.body.style.color = color;
    }
}

let settings = new Settings();