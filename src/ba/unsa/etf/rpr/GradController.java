package ba.unsa.etf.rpr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GradController {
    public TextField fieldNaziv;
    public TextField fieldBrojStanovnika;
    public ChoiceBox<Drzava> choiceDrzava;
    public ObservableList<Drzava> listDrzave;
    public Slider sliderZagadjenost;
    private Grad grad;

    public GradController(Grad grad, ArrayList<Drzava> drzave) {
        this.grad = grad;
        listDrzave = FXCollections.observableArrayList(drzave);
    }

    @FXML
    public void initialize()
    {
        choiceDrzava.setItems(listDrzave);
        if (grad != null)
        {
            ////////////////
            sliderZagadjenost.setValue(grad.getZagadjenost());

            sliderZagadjenost.setMax(10);
            sliderZagadjenost.setMin(1);

            fieldNaziv.setText(grad.getNaziv());
            fieldBrojStanovnika.setText(Integer.toString(grad.getBrojStanovnika()));
            // choiceDrzava.getSelectionModel().select(grad.getDrzava());
            // ovo ne radi jer grad.getDrzava() nije identički jednak objekat kao član listDrzave
            for (Drzava drzava : listDrzave)
                if (drzava.getId() == grad.getDrzava().getId())
                    choiceDrzava.getSelectionModel().select(drzava);

        }
        else {
            choiceDrzava.getSelectionModel().selectFirst();
        }
    }

    public Grad getGrad() {
        return grad;
    }

    public void clickCancel(ActionEvent actionEvent) {
        grad = null;
        Stage stage = (Stage) fieldNaziv.getScene().getWindow();
        stage.close();
    }

    public void clickOk(ActionEvent actionEvent) {
        boolean sveOk = true;

        if (fieldNaziv.getText().trim().isEmpty()) {
            fieldNaziv.getStyleClass().removeAll("poljeIspravno");
            fieldNaziv.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fieldNaziv.getStyleClass().removeAll("poljeNijeIspravno");
            fieldNaziv.getStyleClass().add("poljeIspravno");
        }


        int brojStanovnika = 0;
        try {
            brojStanovnika = Integer.parseInt(fieldBrojStanovnika.getText());
        } catch (NumberFormatException e) {
            // ...
        }
        if (brojStanovnika <= 0) {
            fieldBrojStanovnika.getStyleClass().removeAll("poljeIspravno");
            fieldBrojStanovnika.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            fieldBrojStanovnika.getStyleClass().removeAll("poljeNijeIspravno");
            fieldBrojStanovnika.getStyleClass().add("poljeIspravno");
        }

        double dZagadjenost = 1;
        int iZagadjenost = 1;
        try {
            dZagadjenost = sliderZagadjenost.getValue();

            iZagadjenost = (int)Math.round(dZagadjenost);
        } catch (NumberFormatException e) {
            // ...
        }
        if (iZagadjenost <= 0) {
            sliderZagadjenost.getStyleClass().removeAll("poljeIspravno");
            sliderZagadjenost.getStyleClass().add("poljeNijeIspravno");
            sveOk = false;
        } else {
            sliderZagadjenost.getStyleClass().removeAll("poljeNijeIspravno");
            sliderZagadjenost.getStyleClass().add("poljeIspravno");
        }

        if (!sveOk) return;

        if (grad == null)
            grad = new Grad();

        grad.setNaziv(fieldNaziv.getText());
        grad.setBrojStanovnika(Integer.parseInt(fieldBrojStanovnika.getText()));
        grad.setDrzava(choiceDrzava.getValue());

        if(iZagadjenost < 1 || iZagadjenost > 10)
        {
            grad.setZagadjenost(1);
        }
        else
        grad.setZagadjenost(iZagadjenost);

        Stage stage = (Stage) fieldNaziv.getScene().getWindow();
        stage.close();
    }
}
