class TipCalculator {
    // 下記にはstaticが必要である。なぜなら、インスタンスがなくとも関数が有効である必要性があるため。
    public int getTipPercentage(List<String> people) { 
        if(people.size() > 5) {
            return 20;
        } else if (people.size() > 0) {
            return 10;
        } else {
            return 0;
        }
    }
}