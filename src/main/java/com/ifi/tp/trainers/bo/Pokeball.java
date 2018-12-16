package com.ifi.tp.trainers.bo;

public class Pokeball extends Item {

    public final static Pokeball pokeball = new Pokeball("Poké ball",
            1,
            200,
            100,
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAASbSURBVGhD7ZbLjxRVFMYrogSJO3EFJBLixi1RMYAoJpgQER9BzDBGuxsHmsWAiSSEf4BZGBdiotGNLAcdEhcSFz4SZGaiTpxXVU91dz37MT0NOFHmFYdY13PunNakc2qququmetNf8kt3qu4557vPukpXXXUVXeK4ssnbp+z19iuXgCHvgKIB88Aqgf9V+Q7bQFuhKA9QeOcEpnaKA8oA/FbhV7QCxFTgd8A7qOygdMlJHFS2gYHPgb+bjbUK5oBZ+RRzUvqNlfec0gNF/+DMRAE6cQdzU5n4JZ5UNkORL7jicQI1PhN7lIeobDyChFth1G9wBTcC6MS3WJPKR5Mc+QTNN4BOfBPLTCSxbPzA5UQ22hOM/EkucZKAhxNkpzVB7x8D7nJJkwQ83PFeVB4lW+GF08cl7ATg5ROyFU4wbTuByB+puEAv3l5lO9kLFgQNNCfpNDALl8ne+sJLFvQY7ylsok4BHSiFugDC5/xZLkFYVg9tEYPvp0Tqvax4/tgJSbovK5/hOy4mLDCwT5NNf0FPL3HBYbj92uOiN90nnnnpGMvbmdOyDRcbkotk01/Qy+tMYCCrhx4WPak186/0ZsSPP4+IpeVlyU/Do+J4OivfYQexLZcjCPD2Fdn0FzRSueAgcIk0zP91b0E0697Cgjh6Mi3bXDv/LpsjCFgd02TTX9CBeS44CFznaA5HHnXrl9/Eyz1pyfCvY/LZDzeHZZtM31k2RxDQgbtk01/7Dx+VRVoFNyv+Li+vSLON0UZwVlCLS0trbV996793rYDeyKa/9h15nQ0OIokOoDey6S93tvZnZe62aJVU/weyCG5YFC4b7ASaHx37XT7D5YVt0v0X2BxBlGbn5smmv5xKrcgFB3F1cEiaezNzVm7YZuGzN1JnZJur14bYHEHY1VqBbPrLcMsjXHAQbrUmek73S4M46t/fvCWXzMLikhz5hvne7Dnhzs6yOYIwStVhsumvGcu9zgWHQcsXpUE0ytGbPS/bcLFBlAHwNkQ2/ZUznVN2ub0RQnB0vxz8Wq7zF2CzIplzF+SyaXfkEatcFTmr8g7Z9Bcs1wdzlrPIJekk6Am9kc31pRnWaJRZiBsLvGimM0L2gqWbpaemCqZXrtXZhElSAg9Tecubcd09ZC+cNMPWZkyXTZokOfCgWs4k2QovzTCemNANT7dLbOIkwNoTefOfQqG+m2y1Jji2rozrhpjBTiS6nOpwZJaErG04H5Gd9gSbJ4eJ1KINx+AcUyxeHKihGrY0D0f6BNloX6paf2S66NQwIZJ3ynJjccWjgDkx97huyjpYUxViM9mIJl2vbpsu2PVGJ2BvyCm2KjUoHqUzdZkDlqrM2cgPMzCHNal8PBqrVrdqpq01ijSATYZTLUfPhK+lA3ciuDWKtSN4DfyPz/CdAW2wLcZMQmxzPjxxbNveQmXjFxxrH+PJ0Fw4KpgzZ7kfUpmNFR6xquFMcUbaAUdd12u7KH1ywi82Xjvgq32fM7YeGIPXg5a/sBshvGTBtyIFhr6DmSlPFsyVcb3o/W+46E3lzRV8Bxv2Bt4qQ1/Muuqqq3WkKP8CpoqXsFY0GwoAAAAASUVORK5CYII="
            );
    public final static Pokeball superball = new Pokeball("Super ball",
            1.5,
            600,
            300,
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAVYSURBVGhD7Zn7bxRVFMf7B2jiDwIGQ2hri43xB4kJTYgoJgSkClWg1AQLxkes0Gi0JWhCKaGllKaR1nTXGP1NExEN/oARIUAor7ZppduW3e5jHtvZ6fbBD8RdNCFp93rO3btQ65nu3e108If9Jp9kOnPvOd8z9zG3bV5OOeXknArd8aUF7nhFvit+NN8d/wmuu/LdsX4Eri/jPXxW0BnbgW1Ft/+HVp6481jBV/GafFesr8AVS4BhJkWybQ/2xRginPPiBbjjLfCGY/8ymAUwUn/iSDleUL7r7m5IPkWZWggwqhMwQrtEmsXT09/efhSSfU+ZsBPM8Uzn5CMirb0q+Ca+DOb1TSrxYsA3CMgp0tujoo7YEphKASrhYoI5MbewsTDhdIKR8FCJnACmWZ8t06x136Ge4zVH2Hzs/fw70oQM2JeKOZu2vQdvCDvZyfV+XRtbl8fScalyE2lSBuxLxZyLu7r2uLCVmRo/bFwR3bh8hgo6FycKGd+4fLrpk6YnhT15na568woVkMKJQpBfqiq7hD051dV1PnF7w5IEFYzCqUKmNixNoDdhM70aP25tv1bxMpOls3o/aVIG7EvFtKLxo2MnhM30gnNPL5U0Uwo7Jllx8xCnsGOKbJMxrni3sDm/+FE8k1MsQfExL1u9u4GVvrKNlW4qTwLXz+05zJ9RfeSJzaz6Ova4sGstaFzx387ylBy8wNaUVdwvYOtb73JSP+OzkvpLZF95YtuFXWvBsaCZ7pye4hYvW7N5Bze8/3AzM6MTLCUzOs5qG5qSBZXtZEUtI2QMGcBjk7BrLWh4am5HWfh0AqMHjrSwRCLBC5ienuag8F5dw1HeZvWeBjKGHLGTwq61Ctsnrj/VMcEypahNY6Wbk2sC3z7qzLkLbH15JefX8xf5PXzGRwXaFn0RJmNJcFXYtdbz26v/5omypLzqPW4YR+GlrTvv38diUiMze81kA3oUdq217e0PbCsEzafur3/dvkLQo7BrLa+q9wU0nWWKxzfC1pa9wROlphZOJz61oIizFy/ze4Y5xttg28ERPxkrHT5F7xV2raWb0XPmxBTLhn0H6rlJ3LGsFvun9Y28Tc1nDWQMGTRz7Kywa63QqHmK6izDjf4B9uKW5DcEt9rUyKAiY1FWeyhZBLbp/sNDxpAhGI6k37V8WqTNGJ8kA8jw85nf2QuvJb8lyJZd73BSP6+DZ6d/O0/2lcGITjKfPtoq7FrLr+slMCoJKogsN/o9fOqsffXBEQWv8V7PzUGyjywwGgmvohQLu/PLq4anqCCZEtRHWVdPH7vS28evqTaZgt6EzfQaUcM/KsYYGehhgp6gkB+EzfTyRqMrhwLaTGQBa8Vu0MtQSJtGb8KmnLyK1u1T7ZkOduDTwjAa+jVhT15YuSegzMDiIgM7SQA8oJeAYWT+xweUTzHcA34FdwoygRNgbvTg1412YSs73QrpGgYa0UZZhEi0WGAuH+TE3F4lrAg72UtV1WXDQfUuBhwKanA8GCcT24kWibJByJXMqcf9/rH0v9rKCD+SEPgeBuZvSNWZDskoEwsBC/AqOs+BDAbVe5hb2LBHimI8OxRU/0olQWA7hIVoMDhoMjObrRr6YF9czDjas2PjLLC9iJT4NAtp+uyED1B5YbhlB3SDwTGHKYAKHzEEr/EePsM22HYgoBJxoAhVDymKsvj/LMXdDLdDysRC8PiVGSjyS5HGGeF3BtbKdUieoExlAsaAtXF12DRXiPDOCwvCs9lwSI9RJucD+0Dfkw+1AEqqaa7yq6Ot+HZvKboB6+kObhAIXuM9fJZsI3kUzymnnGxQXt4/Zyepm7m17JEAAAAASUVORK5CYII=");
    public final static Pokeball hyperball = new Pokeball("Hyper ball",
            2,
            1200,
            600,
            "data:image/png;base64,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");
    public final static Pokeball masterball = new Pokeball("Master ball",
            255,
            0,
            0,
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAViSURBVGhD7ZdJbBxFFIZHVgibkEACjkRCCLFcuICXQ4wEEiARW8qCYxM7iUEG7BjihEA4wAEEzoFFRJaQEjixKMJBggsnFhFsRwITb7P0rN2zdPfM2BjiLfbY3UX9NTVjZ6iZbs9iX+aXPsXTXe+9v7pfVVccVVVVVekiDlLjcqRqnY7l0y7HykX676TLsTxLWeHMpq+xe286HanHEMPDt0/a0VSj796VAWosTCGbJOy7b3VA60jt5um2Tlq7+aDea3hnPiYk2mKIzNki2moQ5NCOGZJ6mDzA01dW0SPGZ8kzpjnzCSEgftoUmrND/C2T5QCJfsOMdRhneZnyS+0it2g9hpQpmC38dvETSLyzPoEMarfhMvebN/Oy5ZHaSu7UTxjJ3GJA7y1+AhqNFeXU+owEavLypQlPQz9pTIsKAeXptayhlvoTpPap5oIcrDuZHa88sybMCVCzLG9C7THcogJg+kNCpDtSWUMiwyIy4xE7/ZE4N0A7cRvFSe0wBkSJM0T2rD/9jROw+xtEmvO/BRA7VOTCjrWY9yf713ebXPTjtPd3rBsBVoZzfzNuWGG5RDVA4gO6O1Ev3JZ9iXacDCjouXWDCY6V4dzfGZCr0CTU7jU3t2VPcmuqXtib9KMT2btG3DuvN5ABC7St9pTt3xtBTuRGjdy68CI/l6rj9qwVeGj1vPqiQZLvmST5Pn3ip0wSpr0q3bW+YCuFdHeK1UJN1E6+axJ4CTy8eo7bK6z0wayos01FcTpWFFsHQJwURQnsMlGzSD7d9T1rl91PtjDQNmfv+YHdE8XYZcqRepTbzC9+JBYmsGLoJp0caHgtu1hzOVB/nAzfGBfG2mP5DW4zv+jAwf8HWjNRs0D2NfQyo02HXiC//D5CFpeWGL8OjZD9na9kJ1HCmxjkNvOLvoEpQaAlaBsY3PN8J7k6N09y9e/VOfJsWycbg3YS5bAC/yniNvOLvqa/RcFWtNa9zsz9fGmYGR7+Y5QZBpf//Itd++m3ITYm31ZqBZ3ADLeZX41PtLAixbK0dI2ZxZvIXENLQQuLi9eNLYaGpqbbuFWxGptLmwB6Htq2CUQ0/Z9YPEk2S3t3HyuABQuhbWAcXB69wq5hYWMMxopyWBHR4rPcZn7JMd0vCrbi/JcXmDnsNqJFPDc/T/Ye6WJjPv/mW2EOKxRV93Gb+eWPxIZEwVYoMY0c7DrGDGLhYsGiZeYXFtmT33f0ZXav7aVXSTimC3NY4QtHR7jN/JKU8HdRQbAdpjw+Oon0t0AEzGOMKNYKeHKHwhe5zfxyh2KHQ1FNmMQOiqqRc19dIB09feRxuiEA/P3F14PsnijGDkHqSQpF27nN/KLtusMdVBZESbYTF/UEb9xmYbmC8nCI9rQo0XYQiqp0AvIQt2ctpxx7ZMIbNCN6QphwK4lSD/ACT9yePbkC8rg7GBYm3UrgAV64LftyadqucSlgSHJEmHgrkEIRMu4NGPDCbW1OHjl8ZkwKEA9NFItvbTt5QmHCalMP3E5xcgVCY0jkDMhE0eLCYuVE0XRWK11TucJtFC8nITun/IqOhGNSkHhpS1VicUe0BMuNGqiFmqjNbZSmMVm+3emX1fQkAoSuDfaKQ+xIUMpkEnSL1LPtkoHVojV5+fIITwO7wcZCgG5xdKdQiFeJ0q+ligMXTo1s+0tPLsH+xjXcC0RUNhYx4zQ2N58zEB4t25MXyRNS+rEz5BYuFeREbl6mssK2hreBVhKZ2QzIgY2i6K2yFOHr6A7IlyZ9wVWRuUIgBrGb/sJWQjhk4aRIF+OPdOuLTnqD18Ykv7lu2G/iGt0eoxiDsbYPZlVVVVUBORz/AZfFHMdYdT3zAAAAAElFTkSuQmCC");

    private double bonus_ball;
    private int resale_price;


    public Pokeball(String name, double bonus_ball, int buying_price, int resale_price, String img) {
        super(name, img, buying_price);
        this.bonus_ball = bonus_ball;
        this.resale_price = resale_price;
    }

    public Pokeball(){

    }

    public double getBonus_ball() {
        return bonus_ball;
    }

    public void setBonus_ball(double bonus_ball) {
        this.bonus_ball = bonus_ball;
    }

    public int getResale_price() {
        return resale_price;
    }

    public void setResale_price(int resale_price) {
        this.resale_price = resale_price;
    }

}