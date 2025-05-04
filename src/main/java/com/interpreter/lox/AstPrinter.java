package com.interpreter.lox;

public class AstPrinter implements Expr.Visitor<String>, Stmt.Visitor<Void> {
    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitAssignExpr(Expr.Assign expr) {
        //TODO
        return "";
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        return parenthesize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitCallExpr(Expr.Call expr) {
        //TODO
        return "";
    }

    @Override
    public String visitGetExpr(Expr.Get expr) {
        //TODO
        return "";
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return parenthesize("group", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitLogicalExpr(Expr.Logical expr) {
        //TODO
        return "";
    }

    @Override
    public String visitSetExpr(Expr.Set expr) {
        //TODO
        return "";
    }

    @Override
    public String visitThisExpr(Expr.This expr) {
        //TODO
        return "";
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return parenthesize(expr.operator.lexeme, expr.right);
    }

    @Override
    public String visitVariableExpr(Expr.Variable expr) {
        //TODO
        return "";
    }

    private String parenthesize(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();

        builder.append("(").append(name);
        for (Expr expr: exprs) {
            builder.append(" ");
            builder.append(expr.accept(this));
        }
        builder.append(")");

        return builder.toString();
    }

    @Override
    public Void visitBlockStmt(Stmt.Block stmt) {
        //TODO
        return null;
    }

    @Override
    public Void visitClassStmt(Stmt.Class stmt) {
        //TODO
        return null;
    }

    @Override
    public Void visitExpressionStmt(Stmt.Expression stmt) {
        //TODO
        return null;
    }

    @Override
    public Void visitFunctionStmt(Stmt.Function stmt) {
        //TODO
        return null;
    }

    @Override
    public Void visitIfStmt(Stmt.If stmt) {
        //TODO
        return null;
    }

    @Override
    public Void visitPrintStmt(Stmt.Print stmt) {
        //TODO
        return null;
    }

    @Override
    public Void visitReturnStmt(Stmt.Return stmt) {
        //TODO
        return null;
    }

    @Override
    public Void visitVarStmt(Stmt.Var stmt) {
        //TODO
        return null;
    }

    @Override
    public Void visitWhileStmt(Stmt.While stmt) {
        //TODO
        return null;
    }

    public static void main(String[] args) {
        Expr expression = new Expr.Binary(
                new Expr.Unary(
                        new Token(TokenType.MINUS, "-", null, 1),
                        new Expr.Literal(123)),
                new Token(TokenType.STAR, "*", null, 1),
                new Expr.Grouping(
                        new Expr.Literal(45.67)));
        System.out.println(new AstPrinter().print(expression));
    }
}
