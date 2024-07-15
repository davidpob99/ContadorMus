/*
 *  Copyright (c) 2024 David Población.
 *
 *  This file is part of ContadorMus.
 *
 *  ContadorMus is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ContadorMus is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with ContadorMus.  If not, see <https://www.gnu.org/licenses/>.
 */

package es.davidpob99.ContadorMus;

import android.text.InputFilter;
import android.text.Spanned;

public class CustomRangeInputFilter implements InputFilter {
    private final double minValue;
    private final double maxValue;

    public CustomRangeInputFilter(double minVal, double maxVal) {
        this.minValue = minVal;
        this.maxValue = maxVal;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dStart, int dEnd) {
        try {
            // Remove the string out of destination that is to be replaced
            String newVal = dest.toString().substring(0, dStart) + dest.toString().substring(dEnd);
            newVal = newVal.substring(0, dStart) + source.toString() + newVal.substring(dStart);
            double input = Double.parseDouble(newVal);

            if (isInRange(minValue, maxValue, input)) {
                return null;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean isInRange(double a, double b, double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}