public class PhraseFilter implements Filter {
    private String whereToSearch;
    private String phraseToSearch;

    public PhraseFilter(String phrase, String where) {
        whereToSearch = where;
        phraseToSearch = phrase;
    }

    public boolean satisfies(QuakeEntry qe) {
        if ((whereToSearch == "start" && qe.getInfo().startsWith(phraseToSearch)) ||
                (whereToSearch == "any" && qe.getInfo().contains(phraseToSearch)) ||
                (whereToSearch == "end" && qe.getInfo().endsWith(phraseToSearch))) {
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Phrase";
    }
}