package by.leverx.hateoas.hateoastask.exception;

/**
 * @author Valeryia Zubrytskaya
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Object entity, long id) {

        super(entity + " with id=" + id + " doesn't exist.");

    }

}
