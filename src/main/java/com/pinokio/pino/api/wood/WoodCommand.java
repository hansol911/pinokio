package com.pinokio.pino.api.wood;

import com.pinokio.pino.api.model.Wood;
import lombok.Getter;
import lombok.Setter;

public class WoodCommand {

    @Getter
    @Setter
    public static class CreateWood {
        private String woodName;
        private String woodName2;

        public Wood toWood() {
            Wood wood = new Wood();
            wood.setWoodName(woodName);
            wood.setWoodName2(woodName2);
            return wood;
        }
    }

    @Getter
    @Setter
    public static class UpdateWood {
        private String woodName;
        private String woodName2;

        public Wood toWood(Wood wood) {
            wood.setWoodName(woodName);
            wood.setWoodName2(woodName2);
            return wood;
        }
    }


}
