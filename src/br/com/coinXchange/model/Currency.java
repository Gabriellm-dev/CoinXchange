package br.com.coinXchange.model;

public class Currency {
    private String code;
    private String name;

    // Construtor
    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Métodos getters e setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Método toString para representação textual da moeda
    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
