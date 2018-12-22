package base;

import java.util.Random;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(float x, float y) {
        Vector2D result = new Vector2D(this.x + x, this.y + y);
        return result;
    }

    public Vector2D add(Vector2D other) {
        return this.add(other.x, other.y);
    }

    public Vector2D addThis(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addThis(Vector2D other) {
        return this.addThis(other.x, other.y);
    }

    public Vector2D substract(float x, float y){
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D substract(Vector2D other) {
        return this.substract(other.x, other.y);
    }

    public Vector2D substractThis(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D substractThis(Vector2D other) {
        return this.substractThis(other.x, other.y);
    }

    public Vector2D scale(float rate) {
        return new Vector2D(this.x * rate, this.y * rate);
    }

    public Vector2D scaleThis(float rate) {
        this.x *= rate;
        this.y *= rate;
        return this;
    }

    public float length() {
        return (float)Math.sqrt(x * x + y * y);
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Vector2D set(Vector2D other) {
        return this.set(other.x, other.y);
    }

    public Vector2D setLength(float length) {
        float currentLength = this.length();
        this.scaleThis(length / currentLength);
        return this;
    }

    public Vector2D rotate(double angle) {
        double radians = Math.toRadians(angle);
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        return new Vector2D(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
    }

    public Vector2D setAngle(double angle) {
        double length = this.length();
        this.x = (float)(length * Math.sin(angle));
        this.y = (float)(length * Math.cos(angle));
        return this;
    }

    public double getAngle() {
        return Math.atan(this.y / this.x);
    }

    public double angle() {
        double angle = -Math.atan(this.x / this.y);
        return this.y > 0 ? angle + Math.PI : angle;
    }

    public double angleTo(Vector2D other) {
        return other.substract(this).angle();
    }
}
