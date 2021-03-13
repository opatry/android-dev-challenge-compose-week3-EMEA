/*
 * Copyright (c) 2021 Olivier Patry
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package net.opatry.speedrun.emea.data

import net.opatry.speedrun.emea.R
import net.opatry.speedrun.emea.model.MySootheActivity
import net.opatry.speedrun.emea.model.MySootheCollection

val mySootheCollections = listOf(
    MySootheCollection(R.string.short_mantras, R.drawable.pexels_damir_mijailovic_3578336),
    MySootheCollection(R.string.nature_meditations, R.drawable.pexels_nothing_ahead_3571551),
    MySootheCollection(R.string.stress_and_anxiety, R.drawable.pexels_jim_1557238),
    MySootheCollection(R.string.self_massage, R.drawable.pexels_scott_webb_1029604),
    MySootheCollection(R.string.overwhelmed, R.drawable.pexels_ruvim_3560044),
    MySootheCollection(R.string.nightly_wind_down, R.drawable.pexels_jakub_novacek_924824),
)

val mySootheBodyActivities = listOf(
    MySootheActivity.BodyActivity(
        R.string.inversions,
        R.drawable.pexels_chevanon_photography_317157
    ),
    MySootheActivity.BodyActivity(
        R.string.quick_yoga,
        R.drawable.pexels_agung_pandit_wiguna_1812964
    ),
    MySootheActivity.BodyActivity(R.string.stretching, R.drawable.pexels_cliff_booth_4056723),
    MySootheActivity.BodyActivity(R.string.tabata, R.drawable.pexels_elly_fairytale_4662438),
    MySootheActivity.BodyActivity(R.string.hiit, R.drawable.pexels_the_lazy_artist_gallery_999309),
    MySootheActivity.BodyActivity(R.string.pre_natal_yoga, R.drawable.pexels_freestocksorg_396133),
)

val mySootheMindActivities = listOf(
    MySootheActivity.MindActivity(R.string.meditate, R.drawable.pexels_elly_fairytale_3822622),
    MySootheActivity.MindActivity(R.string.with_kids, R.drawable.pexels_valeria_ushakova_3094230),
    MySootheActivity.MindActivity(
        R.string.aromatherapy,
        R.drawable.pexels_karolina_grabowska_4498318
    ),
    MySootheActivity.MindActivity(R.string.on_the_go, R.drawable.pexels_suraphat_nueaon_1241348),
    MySootheActivity.MindActivity(R.string.with_pets, R.drawable.pexels_cottonbro_4056535),
    MySootheActivity.MindActivity(R.string.high_stress, R.drawable.pexels_nathan_cowley_897817),
)