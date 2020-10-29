package application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Marmita")
public class Marmita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String Tamanho;

    public int getId() {
        return id;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Object get() {
        return null;
    }
}