var func = function f1(some) {
    return function (f1) {
        return func(f1);
    }
}

func(func())
