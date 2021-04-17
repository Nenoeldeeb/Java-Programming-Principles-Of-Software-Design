
public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        for(int i=0;i<myWords.length;i++){
            ret += myWords[i]+" ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if(this.length() != other.length())return false;
        for(int i=0;i<myWords.length;i++){
            if(! myWords[i].equals(other.wordAt(i))){ return false;}
        }
        return true;

    }

    public WordGram shiftAdd(String word) {	
        WordGram out = new WordGram(myWords, 0, myWords.length);
        String[] copy = new String[myWords.length];
        for(int i=1;i<myWords.length;i++){
            copy[i-1] = myWords[i];
        }
        copy[myWords.length-1] = word;
        out.setMyWords(copy);
        return out;
    }

    public void setMyWords(String[] words) {
        this.myWords = words;
    }
    public int hashCode(){
        return myHash = this.toString().hashCode();
    }
}