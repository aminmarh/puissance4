package com.example.puissance4.console;

import com.example.puissance4.hci.IOutput;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Component
public class ConsoleOutput implements IOutput {
    private MessageSource l10n;
    private OutputStream out;

    public ConsoleOutput(MessageSource l10n, OutputStream out) {
        this.l10n = l10n;
        this.out = out;
    }
    @Override
    public void welcome() {
        try{
            out.write(l10n.getMessage("welcome_message", null, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void askPlayerName() {
        try{
            out.write(l10n.getMessage("player_name", null, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void askPlayerType() {
        try{
            out.write(l10n.getMessage("player_type", null, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void alertInvalidNumber() {
        try {
            out.write(l10n.getMessage("number_error", null, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void alertInvalidPlayerType() {
        try {
            out.write(l10n.getMessage("invalid_player_type", null, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void displayBoard(String board) {
        try {
            out.write(board.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void alertInvalidColumn() {
        try {
            out.write(l10n.getMessage("invalid_column", null, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void announceDraw() {
        try {
            out.write(l10n.getMessage("draw_message", null, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void announceVictory(String winner) {
        try {
            out.write(l10n.getMessage("victory_message", new Object[]{winner}, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }

    @Override
    public void goodbye() {
        try {
            out.write(l10n.getMessage("goodbye_message", null, Locale.ENGLISH).getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            // do nothing
        }
    }
}
