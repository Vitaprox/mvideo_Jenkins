package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPage {

    public AbstractPage(){
        init(getWebElementsFields(this), this);
    }

    static void init(List<Field> fields, Object pageObject) {
//        if(fields.stream().noneMatch(el-> el.getName().contains("container"))){
//            initWebElements(fields, pageObject);
//        } else {
//            WebElement webElementContainer = initContainer(fields, pageObject);
//            fields = fields.stream().filter(el->!el.getName().contains("container")).toList();
//            initWebElements(fields,pageObject,webElementContainer);
//        }
        initWebElements(fields, pageObject);
    }

     static WebElement initContainer(List<Field> fields, Object pageObject){
        Field container = fields.stream().filter(el->el.getName().equals("container")).toList().get(0);
        By containerBuildBy = getBy(container);
        setField(container,pageObject,WebElement.get(containerBuildBy));
        return WebElement.get(containerBuildBy);
    }

    static void initWebElements(List<Field> fields, Object pageObject) {
        fields.forEach(field -> {
            By buildBy = getBy(field);
            setField(field, pageObject, WebElement.get(buildBy));
        });
    }

    static void initWebElements(List<Field> fields, Object pageObject, WebElement container) {
        final WebElement finalContainer = container;
        fields.forEach(field -> {
            By buildBy = getBy(field);
            setField(field, pageObject, finalContainer.find(buildBy));
        });
    }

    static List<Field> getWebElementsFields(Object pageObject) {
        Field[] fields = pageObject.getClass().getDeclaredFields();
        return Arrays.stream(fields)
                .filter(field -> Objects.nonNull(field.getAnnotation(FindBy.class))
                        && field.getType().equals(WebElement.class))
                .toList();
    }

    static By getBy(Field field) {
        FindBy.FindByBuilder findByBuilder = new FindBy.FindByBuilder();
        FindBy findBy = field.getAnnotation(FindBy.class);
        By result = null;
        if (Objects.nonNull(findBy)) {
            result = findByBuilder.buildIt(findBy, field);
        }
        return result;
    }

    static void setField(Field field, Object fieldOwner, Object fieldValue) {
        field.setAccessible(true);
        try {
            field.set(fieldOwner, fieldValue);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
