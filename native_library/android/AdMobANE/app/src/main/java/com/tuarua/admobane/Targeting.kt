/*
 *  Copyright 2018 Tua Rua Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.tuarua.admobane

import com.adobe.fre.FREObject
import com.google.android.gms.ads.RequestConfiguration.*
import com.tuarua.frekotlin.*

class Targeting() {
    var tagForChildDirectedTreatment: Int? = null
    var tagForUnderAgeOfConsent: Int? = null
    var maxAdContentRating: String? = null

    constructor(freObject: FREObject?) : this() {
        val o = freObject ?: return

        if (Boolean(o["tagForChildDirectedTreatmentSet"]) == true) {
            tagForChildDirectedTreatment = when {
                Boolean(o["tagForChildDirectedTreatment"]) == true -> TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE
                else -> TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE
            }
        }

        if (Boolean(o["tagForUnderAgeOfConsentSet"]) == true) {
            tagForUnderAgeOfConsent = when {
                Boolean(o["tagForUnderAgeOfConsent"]) == true -> TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE
                else -> TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE
            }
        }

        String(o["maxAdContentRating"])?.let { maxAdContentRating = it }
    }
}