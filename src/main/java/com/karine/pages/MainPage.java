package com.karine.pages;

import com.karine.annotations.ElementTitle;
import com.karine.elements.Button;
import org.openqa.selenium.support.FindBy;
@PageTitle("Главная")
public class MainPage extends Page{

    @ElementTitle("Альфа-карта")
    @FindBy(xpath = "//p[text()='АЛЬФА-КАРТА']")
    Button alfaCard;

    @ElementTitle("Заказать")
    @FindBy(xpath = "//span[text()='Заказать']")
    Button order;





}
