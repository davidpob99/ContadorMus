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
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void clickedGit(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://github.com/davidpob99/ContadorMus"));
        startActivity(browserIntent);
    }

    public void clickedLicense(View v) {
        try {
            Intent myIntent = new Intent(AboutActivity.this, TextoActivity.class);
            myIntent.putExtra("action", "license");
            startActivity(myIntent);
        } catch (Exception e) {
            Log.e("OPEN LICENSE", "exception", e);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gnu.org/licenses/gpl-3.0-standalone.html"));
            startActivity(browserIntent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        startActivity(new Intent(AboutActivity.this, MainActivity.class));
        return super.onKeyDown(keyCode, event);
    }
}
