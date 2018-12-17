package com.ifi.tp.trainers.bo;

public class Potion extends Item {

    public final static Potion potion = new Potion("Potion",
            20,
            300,
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAK3SURBVGhD7VddSxRRGN6giILoP0gQQZB50z/I8mdIJfSpkRiCehcFO6VsN113VxdRVLpXdas7iLFuQaTSah8E3gW5i53T+5x9h921122m+TgunAcedjhz5vk4Z86IOQcHy5gubQ1ML9Q2iDoiN2bmf51jGXt4sFBbF8KF43ytyjL2IAaLQJaxBylUoVTT/rdt/bOuDEtft82YNJdl7EEKhcA7gTFpLsvYgxQKqw5cGBnTF2/eNtcYk+ayjD1IoYIClyg8CHRVga5/hXBgERirDuK6qw5xFLKMPUihopBl7KHiaQ0+yTUpBQVb5wTPsYw9uAK24QrYhitgG1KBwov6X+ELz+ttc/Z0gcdnfuuHz5olcI2x1jl7ukAYugJJwRWwja4u8GZK749bABoslz0qeTWIEItjcshOxDOmBGmwXLbwH+kDy55aRYjiaTlkwNkTWi9NNohrjBX7GgWgAS2WzQ5kPGRWf1Trp/saofxr9M/71fbw4DsKblabuDTRGMMzeJZLDLFsNvg4ow5WPFWF+dypZlCED1sALPYG46oKTZZPH8t5dQXGi7coCK9+J+K1QQmEf3285R52gTSgBU2WTxdVTx2iLf8C09mTLWH+k9AwBUgT2myTHt57ahiG/ggF2GX13w5oXb5Dv+fl+20kDWhBE9pskw7oa3GYPnvfzerz10QiwmMOfqX7OwktzIc2PNguedBhG4VR6bocJGCkHWD6N7gEebBdsvhwTx2hg/YDJm0HMSFCE9rwgBfbJgfa3nGz+sJnMix3+zsREPfMLpAX2yaDlbv6KIluQvzVMdkcDBOw031oc4FNeLJ9fNAnbtKs/mXZOOC/AoYhPOAFT7aPD3ov1yD6skc2TZLwMAXIk+3jg7b0s9naLJlXK2wfH+W86oegaJQK1afyfXWW7R0c0kMu9wcPHcLCSOHoNwAAAABJRU5ErkJggg==");
    public final static Potion superPotion = new Potion("Super potion",
            50,
            700,
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAKQSURBVGhD7VZdaxNBFJ0HRRTEP6H+D+2D4s+oXw99aQqi9KH0BwitCH5B6nPVirTii6gQ6EOa/AChNmJstRT6Jmh0O+M9k7vrZr1xs+7HNDAHDtnMzp5z7r2zJMrDwzEWWz8uLW70tokmI7fvNL9fZBl3WNjofRbCjcZmr8sy7iAGy0CWcQcp1N1Wz7S/BubbT23Z+hLYNWkvy7iDFAqBk8CatJdl3EEKha4DV2o3zdWZW/Yaa9JelnEHKVRYwDUKDwJjVcDYHyG8sAiMroO4HquXOAtZxh2kUFnIMu5g1pQBf93+QykoGN8TPscy7uALcA1fgGv4AlxDKqDe+PBX+Hpjc2DPoS6gU58wS433UXhcYy2+51AXMAp9AUXBF+AaY12AeaeO5C0AGixXPfSamkQIvSKH/BfxjH2WNFiuWpi2OkrmHYQIHsohQwaPzxqzPmMZLJ3prz2KCuhAi2Wrg15V15Pd128vG/1mMvoe0oZvz/e5XovWoymQFstWA/1KHaPOdZPdR/gsBcSm0IUmy5cP6tiUNX42GHQYcWz6R6hG16cH7sWmMMXy5UIvq+PUsR3b/QeDQf+HmCBPYQfabFMeyGjaGj6VA4EHKxPGNGfNwfPz4v0kMUkuYpptyoFZVSfIZDet+whvzzt9SveTjE1hFx5sVzzonN5I6z6YdQIgNK02ebBdsdAv1EkS37Pdvy+HyENMlAvYgxfbFgca76w1eCIHGIXDfidCRlMgL7YtBua1OkWd2bfdvyebg6kBh/xOhIxNYR+ebJ8fJDhnhZdl45BpAUdh7F2YY/v8oJF+TOt+UcT7ZQug/0hsnx8k9gmiVZI8N9k+P0jsAo10SzIqgwivX6pzbO/hUR6U+g0pcgPx6gHoDAAAAABJRU5ErkJggg==");
    public final static Potion hyperPotion = new Potion("Hyper potion",
            200,
            1200,
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAALPSURBVGhD7VdNaxNRFM1CEQXxL1nciCu/6kJdidZFN01sVLpokp1Ra1tsFkVK/Vwk40JERUURwU0b/4EYMbZ+tLgTNFLe85439zUf3qSdZiavgTlwyOTNm3PPuXcmH4kYMRxjqvzn0NRibYmoA3JpeuH3QZZxh8nF2hfB3Oa4UKuyjDuIxgKQZdxBMnWzXNPvv63pX3+VYfnrmlmT9rKMO0imYLgVWJP2sow7SKbQdeBs8pI+l7psjrEm7WUZd5BM2QBDZB4E+ipA399CeGBhGF0HcdxXD3EQsow7SKaCkGXcQWc9bbg/t07JKNi4x17HMu4QB3CNOIBrxAFcQwow93L1P/NzL1ab9mzrAJ+H7uj55z/WzeMYa417tnWATTEOEBLiAK7R1wF05s2ObgNAg+V6D5XxzhgTFx/IJjsR19C10GC53kLPzu6k4hUT4MSkbNLydEHrwmufp+gYa7jGD1CBFsv2DipbOm/Mp+/XjV59onX+af29ZeGV1vPvfM5QCLue5imQFsv2Bmr62S7qXNUEGGzofh4BiPa9ZbsA9SlUocny0UNlvWG/+/e0Hmgw2o64bRAC5k/ONJ/DBM0UvGGWjxZqoribii2bAMdvNJvZCjFBP8AytLlMdFCZ0ogxP3q3ffdT1NVbb7VO0oSk842EBiaJEKTNZaKBzjzeQ/frdxPg2IRsCIR53O94lc63cpAmaQKQNtXgcuFDZYtpYz5F3ZeMWAaZAIgpjPIUqAaXCxcq/2gvdWjFBDjaoftbJZ4nfworqMVlwwMJjxnzyZY/JkHY7nsCNFOgyfohxrhsONBXSvvoU+KnCXDkumwA7GQQbPc9YWmngFpUk8t3D5UpjhvzI7flwpYbGdyImMIFO4XiOJfvHtSRTybA4Wty4TCJTzcTwKtw+e5Bv1U+mgA9JDXtA5fvHirnHYCgVCgKopbKPRzg8jFiRIdE4h/lNbhVJOfaOwAAAABJRU5ErkJggg==");
    public final static Potion potionMax = new Potion("Potion max",
            1000,
            2500,
            "data:image/png;base64,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"); // Restore all the HP
    public final static Potion guerison = new Potion("Guérison",
            1000,
            3000,
            "data:image/png;base64,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"); // Restore all the HP and change statut

    private int hp_restore;
    private boolean remove_status;


    public Potion(String name, int hp_restore, int price, String img) {
        super(name, img, price);
        this.hp_restore = hp_restore;
        this.remove_status = false;
    }

    public Potion(String name, int hp_restore, int price, boolean remove_status, String img) {
        super(name, img, price);
        this.hp_restore = hp_restore;
        this.remove_status = remove_status;
    }

    public Potion(){

    }

    public int getHp_restore() {
        return hp_restore;
    }

    public void setHp_restore(int hp_restore) {
        this.hp_restore = hp_restore;
    }

    public boolean isRemove_status() {
        return remove_status;
    }

    public void setRemove_status(boolean remove_status) {
        this.remove_status = remove_status;
    }
}
