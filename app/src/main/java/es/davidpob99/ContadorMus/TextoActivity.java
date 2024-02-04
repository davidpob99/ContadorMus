/*
 * Copyright (c) 2016 - 2019 David Población.
 *
 * This file is part of ContadorMus.
 *
 * ContadorMus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ContadorMus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ContadorMus.  If not, see <https://www.gnu.org/licenses/>.
 */

package es.davidpob99.ContadorMus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

import ru.noties.markwon.Markwon;

import static android.text.Html.fromHtml;

public class TextoActivity extends AppCompatActivity {

    TextView texto;
    String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);
        action = getIntent().getStringExtra("action");
        texto = findViewById(R.id.tvTexto);

        switch (action) {
            case "privacy":
                texto.setText(fromHtml(getString(R.string.privacy_text)));
                setTitle(getString(R.string.action_privacy));
                break;

            case "third":
                Markwon.setMarkdown(texto, getString(R.string.third_text));
                setTitle(getString(R.string.action_third));
                break;

            case "license":
                startActivity(new Intent(TextoActivity.this, AboutActivity.class));
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.license_url)));
                startActivity(browserIntent);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (action) {
            case "privacy":
                startActivity(new Intent(TextoActivity.this, MainActivity.class));
                break;
            case "third":
                startActivity(new Intent(TextoActivity.this, MainActivity.class));
                break;
            case "license":
                startActivity(new Intent(TextoActivity.this, AboutActivity.class));
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
