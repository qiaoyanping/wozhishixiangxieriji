package com.xjt.nlp.word;


import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
public class Sentence {
    private List sentence = new LinkedList();
    public Sentence() {
    }

 
    // �õ�ĳ���ʻ�

    public Word getWord(int index){
        return (Word)sentence.get(index);
    }

   
     //�õ�һ�仰�Ĵʻ�����
 
    public int totalWords(){
        return sentence.size();
    }

  
    // ��һ�仰���������һ����

    public void addWord(Word word){
        sentence.add(word);
    }

   
    // ��һ�仰��ȥ��ĳ����

    public void removeWord(Word word){
        sentence.remove(word);
    }

 
    public void removeWord(int index){
        sentence.remove(index);
    }

    
     // �ϳ�һ�������ľ��ӣ������κδ��Ա�ע

    public String toSentence(){
        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<sentence.size();i++){
            Word word = (Word)sentence.get(i);
            buffer.append(word.getWord());
        }
        return buffer.toString();
    }

   
    // �ϳ�һ�������Ա�ע�ľ���
 
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for (int i=0;i<sentence.size();i++){
            Word word = (Word)sentence.get(i);
            buffer.append(word.toString());
        }
        return buffer.toString();

    }

    /**
     * �������е����ɸ����ʺͲ�
     * @param startIndex ��ʼҪ�ϲ��ĵ��ʵ�λ��
     * @param endIndex ���һ��Ҫ�ϲ��ĵ��ʵ�λ��
     * @param newAttr �ϲ�����´���
     */
    public void mergeWord(int startIndex, int endIndex, String newAttr){
        if (startIndex<0 || endIndex>=sentence.size())
            throw new IllegalArgumentException("�ʻ�ϲ��Ŀ�ʼλ�úͽ���λ�ò���ȷ");
        if (startIndex>=endIndex)
            throw new IllegalArgumentException("�ʻ�ϲ��Ŀ�ʼλ�ò��ܴ��ڻ��ߵ��ڽ���λ��");
        Word startWord=(Word)sentence.get(startIndex);
        for (int i=startIndex+1;i<=endIndex;i++){
            Word word = (Word) sentence.get(startIndex+1);
            startWord.setWord(startWord.getWord()+word.getWord());
            sentence.remove(startIndex+1);
        }
        startWord.setAttribute(newAttr);
    }

    public static void main(String[] args) {
        Sentence sentence=new Sentence();
        Word word1 = new Word("����","n");
        Word word2 = new Word("����","nr");
        Word word3 = new Word("�Ƽ���ѧ","n");
        sentence.addWord(word1);
        sentence.addWord(word2);
        sentence.addWord(word3);
        System.out.println(sentence.totalWords());
        sentence.removeWord(word2);
        System.out.println(sentence.toSentence());
        sentence.mergeWord(0,1,"nz");
        System.out.println(sentence.toString());
    }



}