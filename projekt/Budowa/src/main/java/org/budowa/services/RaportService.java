package org.budowa.services;

import org.budowa.entities.Building;
import org.budowa.texts.Translations;

public class RaportService {
    public static RaportService inject() {
        return new RaportService();
    }


    private final PdfBuilder pdfBuilder = PdfBuilder.inject();
    private final DialogService dialogService = DialogService.inject();


    public void print(String title, Building[] buildings) {
        try {

            var builder = this.pdfBuilder.create(title).addText(title).addEmptyLine();
            for (var building : buildings) {
                builder = builder.addDataBlock("Nazwa:", building.getName())
                        .addDataBlock("Status:", building.getStatus().toString())
                        .addEmptyLine();
            }
            builder.save();
            this.dialogService.showInfoDialog(Translations.SUCCESSFULLY_SAVED_PDF);
        } catch (NullPointerException ignored) {
        } catch (Exception ex) {
            this.dialogService.showErrorDialog(Translations.SOMETHING_WENT_WRONG);
        }
    }

}
