package com.senai.aula11devops.models;
public class Produto {

    //Atributos do produto

    private  int id;
    private  String nome;
    private double preco;

    // Construtor

    public  Produto(int id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }


    // Getters para pegar o id
    public  int getId(){
        return id;

    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return  preco;
    }


    
}