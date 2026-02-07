@org.springframework.modulith.ApplicationModule(
        allowedDependencies = {
                "inventory::exposed",
                "payment::service"
        }
)
package com.autumnia.mymodulith.order;